package com.study.ikmyeongshopteam4.repository;

import com.study.ikmyeongshopteam4.domain.CollectionsProduct;
import com.study.ikmyeongshopteam4.domain.PaymentProduct;
import com.study.ikmyeongshopteam4.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public List<CollectionsProduct> getProductList(Map<String,Object> map) throws Exception;

    public Product getProduct(int pdtId) throws Exception;

    public PaymentProduct getPaymentProduct(int pdtDtlId) throws Exception;
}