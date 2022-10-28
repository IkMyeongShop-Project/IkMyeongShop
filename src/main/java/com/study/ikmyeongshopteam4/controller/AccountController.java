package com.study.ikmyeongshopteam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/account/register")
    public String register() {
        return "account/register";
    }

    @GetMapping("/account/register_ok")
    public String registerOk() {
        return "account/register_ok";
    }

}
