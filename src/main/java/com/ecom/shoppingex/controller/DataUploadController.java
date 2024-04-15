package com.ecom.shoppingex.controller;

import com.ecom.shoppingex.catalog.dto.CatalogProduct;
import com.ecom.shoppingex.shopper.dto.request.ShopperData;
import com.ecom.shoppingex.catalog.service.CatalogService;
import com.ecom.shoppingex.shopper.service.ShopperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/internal")
public class DataUploadController {


    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ShopperService shopperService;

    @PutMapping("/shoppers")
    public ResponseEntity uploadShopper(@RequestBody @Valid List<ShopperData> shopperSelection) {
        shopperService.updateShoppers(shopperSelection);
        return ResponseEntity.created(URI.create("/shopper/")).build();
    }

    @PostMapping("/products")
    public ResponseEntity addProducts(@RequestBody @Valid List<CatalogProduct> products) {
        catalogService.uploadProducts(products);
        return ResponseEntity.created(URI.create("/products/")).build();
    }


}
