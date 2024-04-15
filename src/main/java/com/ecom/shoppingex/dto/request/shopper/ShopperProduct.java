package com.ecom.shoppingex.dto.request.shopper;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ShopperProduct {

    @Getter
    @NotNull(message = "Product Id cannot be null.")
    private String productId;

    @Getter
    @NotNull(message = "Relevance Score cannot be null.")
    private Double relevancyScore;

}
