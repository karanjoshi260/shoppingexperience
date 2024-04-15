package com.ecom.shoppingex.dto.request.catalog;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class CatalogProduct {

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