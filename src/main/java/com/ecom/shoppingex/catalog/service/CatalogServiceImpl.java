package com.ecom.shoppingex.catalog.service;

import com.ecom.shoppingex.catalog.dto.ProductInfoRequest;
import com.ecom.shoppingex.catalog.repository.ProductRepository;
import com.ecom.shoppingex.shopper.entity.EntityTranformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void uploadProducts(List<ProductInfoRequest> products) {

        productRepository.saveAll(products
                .stream()
                .map(EntityTranformers::buildProductEntity)
                .collect(Collectors.toList()));
    }
}
