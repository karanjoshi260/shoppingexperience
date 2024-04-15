package com.ecom.shoppingex.shopper.service;

import com.ecom.shoppingex.shopper.dto.request.ShopperData;
import com.ecom.shoppingex.shopper.dto.response.ShopperDataResponse;
import com.ecom.shoppingex.shopper.dto.request.ShopperRequestSpec;

import java.util.List;

public interface ShopperService {
    void updateShoppers(List<ShopperData> shopperList);

    ShopperDataResponse getShoppersData(ShopperRequestSpec requestSpec);
}
