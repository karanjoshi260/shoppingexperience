package com.ecom.shoppingex.controller.internal;

import com.ecom.shoppingex.dto.request.catalog.CatalogProduct;
import com.ecom.shoppingex.dto.request.shopper.ShopperData;
import com.ecom.shoppingex.service.catalog.CatalogService;
import com.ecom.shoppingex.service.shopper.ShopperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class DataUploaderController {


    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ShopperService shopperService;

    @PutMapping("/shoppers")
    public ResponseEntity shopperItems(@RequestBody @Valid List<ShopperData> shopperSelection) {
        shopperService.updateShoppers(shopperSelection);
        return ResponseEntity.created(URI.create("/shopper/")).build();
    }

    @PostMapping("/products")
    public ResponseEntity addProducts(@RequestBody @Valid List<CatalogProduct> products) {
        catalogService.uploadProducts(products);
        return ResponseEntity.created(URI.create("/products/")).build();
    }


}
