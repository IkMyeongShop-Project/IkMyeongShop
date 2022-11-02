package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.CheckoutRespDto;
import com.study.ikmyeongshopteam4.dto.CollectionListRespDto;
import com.study.ikmyeongshopteam4.dto.ProductRespDto;

import java.util.List;


public interface ProductService {

    public List<CollectionListRespDto> getProductList(String category, int page)throws Exception;

    public ProductRespDto getProduct(int pdtId) throws Exception;

    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;

}
