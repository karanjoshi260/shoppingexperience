package com.ecom.shoppingex.shopper.repository;

import com.ecom.shoppingex.shopper.entity.CustomerSelection;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ShopperSpecifications {

    public Specification<CustomerSelection> categoryFilter(String categoryName) {
        return (root, query, builder) -> builder.equal(root.get("product").get("category"), categoryName);
    }

    public Specification<CustomerSelection> brandFilter(String brandName) {
        return (root, query, builder) -> builder.equal(root.get("product").get("brand"), brandName);
    }
}
