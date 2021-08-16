package com.koreait.alsamo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewsController {
    @RequestMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/error")
    public String error() {
        return "/error";
    }
}
