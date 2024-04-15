package com.ecom.shoppingex.shopper.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ProductResponse {

    @Getter
    private String productId;

    @Getter
    private String category;

    @Getter
    private String brand;

    @Getter
    private Double relevancyScore;


}
