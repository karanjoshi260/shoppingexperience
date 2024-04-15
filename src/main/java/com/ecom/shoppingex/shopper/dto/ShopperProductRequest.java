package com.ecom.shoppingex.shopper.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ShopperProductRequest {

    @Getter
    @NotNull(message = "Product Id cannot be null.")
    private String productId;

    @Getter
    @NotNull(message = "Relevance Score cannot be null.")
    private Double relevancyScore;

}
