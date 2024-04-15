package com.ecom.shoppingex.dto.request.shopper;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;


public class ShopperData {

    @Getter
    @NotNull(message = "Shopper Id cant be null.")
    private String shopperId;

    @Getter
    @NotNull( message= "Shelf cannot be null.")
    private List<ShopperProduct> shelf;


}
