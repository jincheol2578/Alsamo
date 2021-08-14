package com.koreait.alsamo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserEntity param) {
        return "redirect:" + service.login(param);

    }

    @RequestMapping("/loginErr")
    public String login(Model model, @RequestParam(value = "err", defaultValue = "0") int err) {
        switch (err) {
            case 1:
                model.addAttribute("Msg", "아이디를 확인해 주세요");
                break;

            case 2:
                model.addAttribute("Msg", "비밀번호를 확인해 주세요");
                break;

        }
        return "user/loginErr";
    }

    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserEntity param, Model model) throws MessagingException, UnsupportedEncodingException {
        model.addAttribute("Msg", "가입시 사용한 이메일로 인증해 주세요.");
        service.join(param);
        return "user/loginErr";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession hs, HttpServletRequest req) {
        hs.invalidate();
        String referer =req.getHeader("REFERER");
        return "redirect:"+referer;
    }


    //    회원가입시 이메일 인증
    @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
    public String emailConfirm(@RequestParam("userEmail") String uemail,
                               @RequestParam("AuthKey") String authKey, Model model) {

        UserEntity param = new UserEntity();
        param.setAuthkey(authKey);
        param.setUemail(uemail);

        int result = service.chckAuthkey(param);

        switch (result) {
            case 0:
                model.addAttribute("Msg", "인증이 옳바르지 않습니다.");
                break;

            case 1:
                service.upAuth_no(param);
                model.addAttribute("Msg", "회원가입한 정보로 로그인 해주세요!");
                break;
        }

        return "user/loginErr";
    }


    // 비밀번호 찾기
    @RequestMapping("/findPw")
    public String find() {
        return "user/findPw";
    }

    @PostMapping("/findPw")
    public String find(UserEntity param, Model model) {
        try {

            model.addAttribute("Msg", "이메일을 확인해 주세요.");
            service.find(param);

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "user/loginErr";
    }

    // 아이디 찾기
    @RequestMapping("/findId")
    public String findId() {
        return "user/findId";
    }

    @PostMapping("/findId")
    public String findId(UserEntity param, Model model) {
        UserEntity user = service.findId(param);
        if (user.getUid() == null || user.getUid() == "") {
            model.addAttribute("Msg","아이디 혹은 이메일이 확실 하지 않습니다.");
        } else {
            model.addAttribute("Msg", "아이디: "+user.getUid());
        }
        return "user/loginErr";
    }


    // 비번 찾기 이메일 인증
    @GetMapping("/femailConfirm")
    public String findEmailConfirm(@RequestParam("fuserEmail") String fEmail,
                                   @RequestParam("fAuthKey") String fAuthKey,
                                   Model model) {
        UserEntity param = new UserEntity();
        param.setUemail(fEmail);
        param.setAuthkey(fAuthKey);

        int result = service.chckAuthkey(param);
        if (result == 1) {

            model.addAttribute("uemail", param.getUemail());
            return "user/updUser";
        } else {
            return "user/login";
        }

    }

    @PostMapping("/updUser")
    public String updUser(UserEntity param, Model model) {
        model.addAttribute("Msg", "수정된 비밀번호로 로그인 해주세요.");
        service.updUser(param);
        return "user/loginErr";
    }

    @RequestMapping("/myPage")
    public String myPage() {
        return "user/myPage";
    }

    @RequestMapping(value = "/myPage", method = RequestMethod.POST)
    public String myPageMod(UserEntity param, Model model) {

        service.updUser(param);
        return "user/myPage";
    }


    @GetMapping("/errorMsg")
    public String blockUserLogin() {
        return "user/errorMsg";
    }
}