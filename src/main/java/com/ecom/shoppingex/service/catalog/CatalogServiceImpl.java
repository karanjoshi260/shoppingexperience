package com.ecom.shoppingex.service.catalog;

import com.ecom.shoppingex.dto.request.catalog.CatalogProduct;
import com.ecom.shoppingex.repository.ProductRepository;
import com.ecom.shoppingex.util.EntityTranformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void uploadProducts(List<CatalogProduct> products) {

        productRepository.saveAll(products
                .stream()
                .map(EntityTranformers::buildProductEntity)
                .collect(Collectors.toList()));
    }
}
