package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;
import com.study.ikmyeongshopteam4.dto.GoodsRespDto;

import java.util.List;

public interface ProductService {
    public List<GoodsListRespDto> getProductList(String category, int page) throws Exception;

    public GoodsRespDto getGoods(int pdtId) throws Exception;
}
