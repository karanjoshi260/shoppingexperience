package com.ecom.shoppingex.catalog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ProductInfoRequest {

    @Getter
    @NotNull
    private String productId;

    @Getter
    @NotNull
    private String category;

    @Getter
    @NotNull
    private String brand;
}
