package com.study.ikmyeongshopteam4.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductManagementController {

    @GetMapping("/product/register")
    public String productRegister() {
        return "admin/product_addition";
    }
    @GetMapping("/product/registerList")
    public String productAdd(){
        return "admin/product_add";
    }
}
