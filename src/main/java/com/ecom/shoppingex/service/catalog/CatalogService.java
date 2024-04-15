package com.ecom.shoppingex.service.catalog;

import com.ecom.shoppingex.dto.request.catalog.CatalogProduct;

import java.util.List;

public interface CatalogService {

    void uploadProducts(List<CatalogProduct> products);
}
