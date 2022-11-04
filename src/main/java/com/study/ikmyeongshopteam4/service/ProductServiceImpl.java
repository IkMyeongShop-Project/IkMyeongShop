package com.study.ikmyeongshopteam4.service;

<<<<<<< HEAD
import com.study.ikmyeongshopteam4.domain.Product;
import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;
import com.study.ikmyeongshopteam4.dto.GoodsRespDto;
=======
import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;
>>>>>>> 0d1be5f8b43c3c4fc57f4742b11670f6cafa823b
import com.study.ikmyeongshopteam4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<GoodsListRespDto> getProductList(String category, int page) throws Exception {
        List<GoodsListRespDto> productList = new ArrayList<GoodsListRespDto>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category", category);
        map.put("index", (page - 1) * 16);

        productRepository.getProductList(map).forEach(goodsProduct -> {
            productList.add(goodsProduct.toDto());
        });
        return productList;
    }
<<<<<<< HEAD

    @Override
    public GoodsRespDto getGoods(int pdtId) throws Exception {
        Product product = productRepository.getProduct(pdtId);

        if (product == null) {

        }

        return null;
    }
=======
>>>>>>> 0d1be5f8b43c3c4fc57f4742b11670f6cafa823b
}
