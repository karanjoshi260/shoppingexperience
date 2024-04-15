package com.ecom.shoppingex.shopper.util;

import com.ecom.shoppingex.catalog.dto.CatalogProduct;
import com.ecom.shoppingex.shopper.dto.request.ShopperData;
import com.ecom.shoppingex.shopper.dto.request.ShopperProduct;
import com.ecom.shoppingex.catalog.entity.Product;
import com.ecom.shoppingex.shopper.entity.Customer;
import com.ecom.shoppingex.shopper.entity.CustomerSelection;
import com.ecom.shoppingex.shopper.entity.CustomerSelectionPK;

import java.util.stream.Collectors;

public interface EntityTranformers {
    static Product buildProductEntity(CatalogProduct rProduct) {
        return Product.builder()
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
