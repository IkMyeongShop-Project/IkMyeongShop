package com.study.ikmyeongshopteam4.controller;

import com.study.ikmyeongshopteam4.dto.CheckoutRespDto;
import com.study.ikmyeongshopteam4.security.PrincipalDetails;
import com.study.ikmyeongshopteam4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/goods/{category}")
    public String loadGoods(@PathVariable String category) {
        return "goods/goods_list";
    }

    @GetMapping("/product/{pdtId}")
    public String loadProductDetail(@PathVariable int pdtId) {
        return "goods/goods_view";
    }

    @GetMapping("/checkout")
    public String loadPayment(Model model,
                              @RequestParam("pdtDtlId") int pdtDtlId,
                              @AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception{
        CheckoutRespDto checkoutRespDto = productService.getCheckoutProduct(pdtDtlId);
        model.addAttribute("data", checkoutRespDto);
        model.addAttribute("user", principalDetails.getUser());
        return "goods/goods_order";
    }

    @GetMapping("/checkout/complete")
    public String paymentComplete(Model model,
                                  @AuthenticationPrincipal PrincipalDetails principalDetails) throws Exception {
        model.addAttribute("user",principalDetails.getUser());
        return "goods/order_complete";
    }
}