package com.ecom.shoppingex.catalog.service;

import com.ecom.shoppingex.catalog.dto.ProductInfoRequest;

import java.util.List;

public interface CatalogService {

    void uploadProducts(List<ProductInfoRequest> products);
}
