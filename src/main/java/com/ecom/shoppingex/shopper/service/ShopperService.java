package com.ecom.shoppingex.shopper.service;

import com.ecom.shoppingex.shopper.dto.ShopperDataRequest;
import com.ecom.shoppingex.shopper.dto.ShopperDataResponse;
import com.ecom.shoppingex.shopper.dto.ShopperRequestSpec;

import java.util.List;

public interface ShopperService {
    void updateShoppers(List<ShopperDataRequest> shopperList);

    ShopperDataResponse getShoppersData(ShopperRequestSpec requestSpec);
}
