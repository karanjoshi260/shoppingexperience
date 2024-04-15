package com.ecom.shoppingex.entity.shopper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Getter
    @Id
    @Column(name = "id", nullable = false)
    private String customerId;

    @Getter
    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CustomerSelection> customerSelections;
}
