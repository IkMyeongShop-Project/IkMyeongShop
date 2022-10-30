package com.study.ikmyeongshopteam4.api.admin;

import com.study.ikmyeongshopteam4.aop.annotation.LogAspect;
import com.study.ikmyeongshopteam4.aop.annotation.ValidAspect;
import com.study.ikmyeongshopteam4.dto.CMRespDto;
import com.study.ikmyeongshopteam4.dto.admin.ProductRegisterReqDto;
import com.study.ikmyeongshopteam4.service.admin.ProductManagementService;
import com.study.ikmyeongshopteam4.service.admin.ProductManagementServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class ProductAdminApi {

    private final ProductManagementService productManagementService;
    @LogAspect
    @ValidAspect
    @PostMapping("/product")
    public ResponseEntity<?> registerProductMst(@Validated @RequestBody ProductRegisterReqDto productRegisterReqDto, BindingResult bindingResult) throws Exception {
        return ResponseEntity.created(null).body(new CMRespDto<>("Register Successfully", null));
    }

    @GetMapping("/product/category")
    public ResponseEntity<?> getCategoryList() throws Exception {
        return ResponseEntity.ok().body(new CMRespDto<>("get Successfully", productManagementService.getCategoryList()));
    }
}
