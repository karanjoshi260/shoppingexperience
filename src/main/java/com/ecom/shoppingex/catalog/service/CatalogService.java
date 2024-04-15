package com.ecom.shoppingex.catalog.service;

import com.ecom.shoppingex.catalog.dto.CatalogProduct;

import java.util.List;

public interface CatalogService {

    void uploadProducts(List<CatalogProduct> products);
}
