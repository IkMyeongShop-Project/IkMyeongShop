package com.study.ikmyeongshopteam4.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    //pdt_mst db 데이터 들고오기
    private int id;
    private String pdt_name;
    private int category_id;
    private int pdt_price;

}
