package com.study.ikmyeongshopteam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping("/goods/register")
    public String loadGoods(){
        return "goods/goods_list";
    }
}
