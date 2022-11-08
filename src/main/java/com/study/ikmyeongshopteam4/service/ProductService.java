package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;

import java.util.List;

public interface ProductService {
    public List<GoodsListRespDto> getProductList(String category, int page, int limitCount) throws Exception;
}
