package com.study.ikmyeongshopteam4.service;

import com.study.ikmyeongshopteam4.dto.CheckoutRespDto;

public interface productService {
    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;
}
