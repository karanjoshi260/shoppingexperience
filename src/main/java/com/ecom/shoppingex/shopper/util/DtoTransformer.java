package com.ecom.shoppingex.shopper.util;

import com.ecom.shoppingex.shopper.dto.response.ProductResponse;
import com.ecom.shoppingex.shopper.entity.CustomerSelection;

public interface DtoTransformer {

    static ProductResponse buildProductResponse(CustomerSelection customerSelection) {

        return ProductResponse.builder().productId(customerSelection.getProduct().getProductId())
                .brand(customerSelection.getProduct().getBrand())
                .relevancyScore(customerSelection.getRelevancyScore())
                .category(customerSelection.getProduct().getCategory())
                .build();
    }
}
