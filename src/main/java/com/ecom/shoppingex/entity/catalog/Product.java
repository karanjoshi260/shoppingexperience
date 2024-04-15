package com.ecom.shoppingex.entity.catalog;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product", indexes = {@Index(columnList = "brand,category"), @Index(columnList = "brand"), @Index(columnList = "category")})
public class Product {

    @Getter
    @Setter
    @Column(name = "product_id")
    @Id
    private String productId;

    @Getter
    @Setter
    @Column(name = "brand")
    private String brand;

    @Getter
    @Setter
    @Column(name = "category")
    private String category;

}
