package com.study.ikmyeongshopteam4.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login(Model model,
                        @RequestParam @Nullable String username,
                        @RequestParam @Nullable String error) {
        model.addAttribute("username", username == null? "" : username);
        model.addAttribute("error", error == null? "" : error);
        return "account/login";
    }

    @GetMapping("/account/register")
    public String register() {
        return "account/register";}

}
