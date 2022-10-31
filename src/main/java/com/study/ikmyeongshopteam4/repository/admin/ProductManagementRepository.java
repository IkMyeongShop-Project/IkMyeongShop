package com.study.ikmyeongshopteam4.repository.admin;

import com.study.ikmyeongshopteam4.domain.Product;
import com.study.ikmyeongshopteam4.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductManagementRepository {
    public List<ProductCategory> getCategoryList() throws Exception;
    public int saveProductMst(Product product) throws Exception;
}
