package com.study.ikmyeongshopteam4.repository;

import com.study.ikmyeongshopteam4.domain.GoodsProduct;
<<<<<<< HEAD
import com.study.ikmyeongshopteam4.domain.Product;
=======
>>>>>>> 0d1be5f8b43c3c4fc57f4742b11670f6cafa823b
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Mapper
public interface ProductRepository {
    public List<GoodsProduct> getProductList(Map<String, Object> map) throws Exception;
<<<<<<< HEAD

    public Product getProduct(int pdtId) throws Exception;
=======
>>>>>>> 0d1be5f8b43c3c4fc57f4742b11670f6cafa823b
}
