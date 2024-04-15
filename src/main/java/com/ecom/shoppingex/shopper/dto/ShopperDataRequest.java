package com.ecom.shoppingex.shopper.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;


public class ShopperDataRequest {

    @Getter
    @NotNull(message = "Shopper Id cant be null.")
    private String shopperId;

    @Getter
    @NotNull(message = "Shelf cannot be null.")
    @NotEmpty
    private List<ShopperProductRequest> shelf;

}
