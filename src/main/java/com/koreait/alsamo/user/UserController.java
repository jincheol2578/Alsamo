package com.koreait.alsamo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("login")
    public String login() {
        return "user/login";
    }

    @PostMapping("login")
    public String login(UserEntity param){
        return "redirect:"+ service.userLogin(param);
    }
}
