package com.study.ikmyeongshopteam4.repository;

import com.study.ikmyeongshopteam4.domain.GoodsProduct;
import com.study.ikmyeongshopteam4.domain.admin.ProductList;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Mapper
public interface ProductRepository {
    public List<GoodsProduct> getProductList(Map<String, Object> map) throws Exception;
    public List<ProductList> getList(Map<String, Object> map) throws Exception;
}
