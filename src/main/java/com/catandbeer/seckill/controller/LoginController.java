package com.catandbeer.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user_login")
public class LoginController {
    @RequestMapping("to_login")
    public String toLogin(){
        return "login";
    }
}
