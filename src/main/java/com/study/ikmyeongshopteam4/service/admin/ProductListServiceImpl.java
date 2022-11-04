//package com.study.ikmyeongshopteam4.service.admin;
//
//import com.study.ikmyeongshopteam4.dto.admin.ProductListDto;
//import com.study.ikmyeongshopteam4.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class ProductListServiceImpl implements ProductListService{
//
//    private final ProductRepository productRepository;
//
//    @Override
//    public List<ProductListDto> getList() throws Exception;
//    List<ProductListDto> ProductListDtos = new ArrayList<ProductListDto>();
//
//        ProductRepository.getList().forEach(ProductList -> {
//        ProductListDtos.add(ProductList.toDto());
//    });
//        return ProductListDtos;
//}
