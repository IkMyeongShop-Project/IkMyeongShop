package com.study.ikmyeongshopteam4.service.admin;

import com.study.ikmyeongshopteam4.dto.admin.CategoryResponseDto;
import com.study.ikmyeongshopteam4.dto.admin.ProductRegisterReqDto;

import java.util.List;

public interface ProductManagementService {

    public List<CategoryResponseDto> getCategoryList() throws Exception;
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception;
}
