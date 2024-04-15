package com.ecom.shoppingex.controller;

import com.ecom.shoppingex.shopper.dto.request.ProductSortKey;
import com.ecom.shoppingex.shopper.service.ShopperService;
import com.ecom.shoppingex.shopper.dto.request.ShopperRequestSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/external")
public class ShoppingDataController {


    @Autowired
    private ShopperService shopperService;

    @GetMapping(value = "/shoppers/{shopperId}")
    public ResponseEntity loadShopperData(@PathVariable String shopperId,
                                          @RequestParam(name = "offset", defaultValue = "0") int offSet,
                                          @RequestParam(name = "pageSize", defaultValue = "10") int limit,
                                          @RequestParam(name = "category", required = false) String category,
                                          @RequestParam(name = "brand", required = false) String brand,
                                          @RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") Sort.Direction sortOrder,
                                          @RequestParam(name = "sortingKey", required = false) ProductSortKey sortingKey
    ) {

        return ResponseEntity.ok(
                shopperService.getShoppersData(
                        ShopperRequestSpec.builder()
                                .shopperId(shopperId)
                                .offset(offSet)
                                .limit(limit)
                                .sortingKey(sortingKey)
                                .sortOrder(sortOrder)
                                .brand(brand)
                                .category(category)
                                .build()
                ));
    }
}
