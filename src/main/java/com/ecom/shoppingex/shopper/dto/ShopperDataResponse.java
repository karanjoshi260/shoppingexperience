package com.ecom.shoppingex.shopper.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public class ShopperDataResponse {

    @Getter
    private String customerId;

    @Getter
    private List<ProductResponse> productList;
}
