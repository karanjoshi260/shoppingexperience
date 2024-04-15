package com.ecom.shoppingex.shopper.entity;

import com.ecom.shoppingex.catalog.dto.ProductInfoRequest;
import com.ecom.shoppingex.shopper.dto.ShopperDataRequest;
import com.ecom.shoppingex.shopper.dto.ShopperProductRequest;
import com.ecom.shoppingex.catalog.entity.Product;
import com.ecom.shoppingex.shopper.entity.Customer;
import com.ecom.shoppingex.shopper.entity.CustomerSelection;
import com.ecom.shoppingex.shopper.entity.CustomerSelectionPK;

import java.util.stream.Collectors;

public interface EntityTranformers {
    static Product buildProductEntity(ProductInfoRequest rProduct) {
        return Product.builder()
                .productId(rProduct.getProductId())
                .brand(rProduct.getBrand())
                .category(rProduct.getCategory())
                .build();
    }

    static Customer buildCustomerEntity(ShopperDataRequest shopperData) {
        return Customer.builder().customerId(shopperData.getShopperId())
                .customerSelections(
                        shopperData.getShelf()
                                .stream()
                                .map(sp -> getCustomerSelectionEntity(shopperData, sp)
                                )
                                .collect(Collectors.toList()))
                .build();
    }

    private static CustomerSelection getCustomerSelectionEntity(ShopperDataRequest shopperData, ShopperProductRequest sp) {
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
