package com.study.ikmyeongshopteam4.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsRespDto {

    private int pdtId;
    private String pdtName;
    private int pdtPrice;
    private String pdtDesign;
    private List<String> pdtImgs;
}
