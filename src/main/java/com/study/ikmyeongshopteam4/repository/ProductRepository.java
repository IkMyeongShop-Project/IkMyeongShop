package com.study.ikmyeongshopteam4.repository;

import com.study.ikmyeongshopteam4.domain.GoodsProduct;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Mapper
public interface ProductRepository {
    public List<GoodsProduct> getProductList(Map<String, Object> map) throws Exception;
}
