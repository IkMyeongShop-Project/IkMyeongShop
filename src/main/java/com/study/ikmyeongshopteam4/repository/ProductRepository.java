package com.study.ikmyeongshopteam4.repository;

import com.study.ikmyeongshopteam4.aop.domain.GoodsProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public List<GoodsProduct> getProductList(Map<String, Object> map) throws Exception;
}
