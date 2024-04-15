package com.ecom.shoppingex.util;

import com.ecom.shoppingex.dto.response.ProductResponse;
import com.ecom.shoppingex.entity.shopper.CustomerSelection;

public interface DtoTransformer {

    static ProductResponse buildProductResponse(CustomerSelection customerSelection) {

        return ProductResponse.builder().productId(customerSelection.getProduct().getProductId())
                .brand(customerSelection.getProduct().getBrand())
                .relevancyScore(customerSelection.getRelevancyScore())
                .category(customerSelection.getProduct().getCategory())
                .build();
    }
}
