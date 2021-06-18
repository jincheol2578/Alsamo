package com.koreait.alsamo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

import java.io.IOException;
import java.security.GeneralSecurityException;

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
    public String join(UserEntity param) {
        System.out.println(param);
        service.join(param);
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/googleJoin",method = RequestMethod.POST)
    public UserEntity googleJoin(@RequestBody String googleIdToken){
        System.out.println("googleIdToken" + googleIdToken);
        UserEntity googleUSer = null;

        try {
            googleUSer = service.GoogleIdTokenVerifier(googleIdToken);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googleUSer;
    }
}