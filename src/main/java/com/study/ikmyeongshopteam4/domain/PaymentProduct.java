package com.study.ikmyeongshopteam4.domain;

import com.study.ikmyeongshopteam4.dto.CheckoutRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentProduct {
    private int pdt_dtl_id;
    private int pdt_id;
    private String pdt_name;
    private int pdt_price;
    private String pdt_design;
    private String save_name;

    public CheckoutRespDto toDto() {
        return CheckoutRespDto.builder()
                .pdtDtlId(pdt_dtl_id)
                .pdtId(pdt_id)
                .pdtName(pdt_name)
                .pdtPrice(pdt_price)
                .pdtDesign(pdt_design)
                .saveName(save_name)
                .build();
    }
}