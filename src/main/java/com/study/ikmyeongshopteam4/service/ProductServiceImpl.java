package com.study.ikmyeongshopteam4.service;


import com.study.ikmyeongshopteam4.domain.Product;
import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;
import com.study.ikmyeongshopteam4.dto.GoodsRespDto;
import com.study.ikmyeongshopteam4.dto.GoodsListRespDto;
import com.study.ikmyeongshopteam4.exception.CustomValidationException;
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


    @Override
    public GoodsRespDto getGoods(int pdtId) throws Exception {
        Product product = productRepository.getProduct(pdtId);

        if (product == null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("error", "등록되지 않은 상품입니다.");
            throw new CustomValidationException("Get Product Error", errorMap);
        }
        Map<String, List<Object>> pdtDesign =new HashMap<String, List<Object>>();
        List<String> pdtImgs = new ArrayList<String>();

        product.getPdt_dtls().forEach(dtl -> {
            if(!pdtDesign.containsKey(dtl.getPdt_design())) {
            pdtDesign.put(dtl.getPdt_design(), new ArrayList<Object>());
            }
        });

        product.getPdt_dtls().forEach(dtl -> {
            Map<String, Object> pdtDtlAndDesign = new HashMap<String, Object>();
            pdtDtlAndDesign.put("pdtDtlId", dtl.getId());
            pdtDtlAndDesign.put("DesignName", dtl.getPdt_design());
            pdtDtlAndDesign.put("pdtStock", dtl.getPdt_stock());

            pdtDesign.get(pdtDtlAndDesign);
        });

        product.getPdt_imgs().forEach(img -> {
            pdtImgs.add(img.getSave_name());
        });

        GoodsRespDto dto = GoodsRespDto.builder()
                .pdtId(product.getId())
                .pdtName(product.getPdt_name())
                .pdtPrice(product.getPdt_price())
                .pdtDesign(pdtDesign.toString())
                .pdtImgs(pdtImgs)
                .build();

        return dto;
    }


}
