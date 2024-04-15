package com.ecom.shoppingex.entity.shopper;

import com.ecom.shoppingex.entity.catalog.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerSelection {

    @EmbeddedId
    private CustomerSelectionPK id;

    @Getter
    @MapsId("productId")
    @JoinColumn(name="product_id", nullable = false)
    @ManyToOne
    private Product product;

    @Getter
    @MapsId("customerId")
    @JoinColumn(name="customer_id", nullable = false)
    @ManyToOne
    private Customer customer;

    @Getter
    @Column(name="relevancy_score", nullable = false)
    private double relevancyScore;
}
