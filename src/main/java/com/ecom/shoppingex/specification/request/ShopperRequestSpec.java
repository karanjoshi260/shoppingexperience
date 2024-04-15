package com.ecom.shoppingex.specification.request;

import com.ecom.shoppingex.entity.misc.ProductSortKey;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@Builder
public class ShopperRequestSpec {

    @Getter
    private String shopperId;

    @Getter
    private int offset;

    @Getter
    private int limit;

    @Getter
    private String category;

    @Getter
    private String brand;

    @Getter
    private ProductSortKey sortingKey;

    @Getter
    private Sort.Direction sortOrder;

}
