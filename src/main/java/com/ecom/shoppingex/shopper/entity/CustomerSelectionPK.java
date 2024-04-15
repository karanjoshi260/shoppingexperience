package com.ecom.shoppingex.shopper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class CustomerSelectionPK {

    @Setter
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Setter
    @Column(name = "product_id", nullable = false)
    private String productId;

}
