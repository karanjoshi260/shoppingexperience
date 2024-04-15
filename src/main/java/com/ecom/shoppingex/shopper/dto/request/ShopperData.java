package com.ecom.shoppingex.shopper.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;


public class ShopperData {

    @Getter
    @NotNull(message = "Shopper Id cant be null.")
    private String shopperId;

    @Getter
    @NotNull(message = "Shelf cannot be null.")
    @NotEmpty
    private List<ShopperProduct> shelf;

}
