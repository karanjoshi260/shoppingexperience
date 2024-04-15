package com.ecom.shoppingex.util;

import com.ecom.shoppingex.dto.request.catalog.CatalogProduct;
import com.ecom.shoppingex.dto.request.shopper.ShopperData;
import com.ecom.shoppingex.dto.request.shopper.ShopperProduct;
import com.ecom.shoppingex.entity.catalog.Product;
import com.ecom.shoppingex.entity.shopper.Customer;
import com.ecom.shoppingex.entity.shopper.CustomerSelection;
import com.ecom.shoppingex.entity.shopper.CustomerSelectionPK;

import java.util.stream.Collectors;

public interface EntityTranformers {
    static Product buildProductEntity(CatalogProduct rProduct) {
        return com.ecom.shoppingex.entity.catalog.Product.builder()
                .productId(rProduct.getProductId())
                .brand(rProduct.getBrand())
                .category(rProduct.getCategory())
                .build();
    }

    static Customer buildCustomerEntity(ShopperData shopperData) {
        return Customer.builder().customerId(shopperData.getShopperId())
                .customerSelections(
                        shopperData.getShelf()
                                .stream()
                                .map(sp -> getCustomerSelectionEntity(shopperData, sp)
                                )
                                .collect(Collectors.toList()))
                .build();
    }

    private static CustomerSelection getCustomerSelectionEntity(ShopperData shopperData, ShopperProduct sp) {
        return CustomerSelection.builder()
                .id(CustomerSelectionPK.builder()
                        .customerId(shopperData.getShopperId())
                        .productId(sp.getProductId())
                        .build()
                )
                .customer(Customer.builder().customerId(shopperData.getShopperId()).build())
                .product(Product.builder().productId(sp.getProductId()).build())
                .relevancyScore(sp.getRelevancyScore())
                .build();
    }
}
