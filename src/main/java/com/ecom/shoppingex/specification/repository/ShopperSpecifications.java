package com.ecom.shoppingex.specification.repository;

import com.ecom.shoppingex.entity.shopper.CustomerSelection;
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
