package com.ecom.shoppingex.service.shopper;

import com.ecom.shoppingex.dto.request.shopper.ShopperData;
import com.ecom.shoppingex.dto.response.ShopperDataResponse;
import com.ecom.shoppingex.specification.request.ShopperRequestSpec;

import java.util.List;

public interface ShopperService {
    void updateShoppers(List<ShopperData> shopperList);

    ShopperDataResponse getShoppersData(ShopperRequestSpec requestSpec);
}
