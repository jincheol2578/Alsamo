package com.koreait.alsamo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
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

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "err", defaultValue = "0") int err) {
        switch (err) {
            case 1:
                model.addAttribute("errMsg", "아이디를 확인해 주세요");
                break;

            case 2:
                model.addAttribute("errMsg", "비밀번호를 확인해 주세요");
                break;

        }
        return "user/login";
    }

    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserEntity param, Model model, RedirectAttributes rttr) throws MessagingException, UnsupportedEncodingException {
        System.out.println(param);
        rttr.addAttribute("msg", "가입시 사용한 이메일로 인증해 주세요.");
        service.join(param);
        return "redirect:/user/login";
    }

    @ResponseBody
    @RequestMapping(value = "/googleJoin", method = RequestMethod.POST)
    public int googleJoin(@RequestBody UserEntity user) {
        System.out.println("aJax user :" + user);
        int googleUser = service.googleLogin(user);
        System.out.println(googleUser);
        return googleUser;
    }

    @RequestMapping("/googleJoin")
    public String googleJoin() {
        return "user/googleJoin";
    }

    @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
    public String emailConfirm(@RequestParam("userEmail") String uemail,
                               @RequestParam("AuthKey") String authKey, Model model) {

        UserEntity param = new UserEntity();
        param.setAuthKey(authKey);
        param.setUemail(uemail);

        int result = service.chckAuthkey(param);

        switch (result) {
            case 0:
                model.addAttribute("authkeyErr", "인증이 옳바르지 않습니다.");
                break;

            case 1:
                service.upAuthorize(param);
                model.addAttribute("authkeyErr", "회원가입한 정보로 로그인 해주세요!");
                break;
        }

        return "/user/login";
    }
}