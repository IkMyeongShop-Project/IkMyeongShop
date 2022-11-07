package com.study.ikmyeongshopteam4.controller.admin;

import com.study.ikmyeongshopteam4.domain.admin.ProductList;
import com.study.ikmyeongshopteam4.dto.CMRespDto;
import com.study.ikmyeongshopteam4.dto.admin.ProductListDto;
import com.study.ikmyeongshopteam4.service.admin.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterIOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ProductManagementController {

    private final ProductListService productListService;

    @GetMapping("/product/register")
    public String productRegister() {
        return "admin/product_addition";
    }
    @GetMapping("/product/registerList")
    public String productAdd(){
        return "admin/product_add";
    }

    //상품 리스트 불러오기
    @PostMapping("/api/v1/product/{page}")
    public ResponseEntity<?> getProductList(@RequestBody ProductListDto productListDto, @PathVariable int page) {
        List<ProductListDto> listDtos = new ArrayList<>();

        try {
            listDtos = productListService.getList(page);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(new CMRespDto("failed page", listDtos));
        }

        return ResponseEntity.ok().body(new CMRespDto("success page", listDtos));
    }
}
