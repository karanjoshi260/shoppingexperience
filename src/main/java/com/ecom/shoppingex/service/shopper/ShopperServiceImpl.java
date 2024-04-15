package com.ecom.shoppingex.service.shopper;

import com.ecom.shoppingex.dto.request.shopper.ShopperData;
import com.ecom.shoppingex.dto.response.ProductResponse;
import com.ecom.shoppingex.dto.response.ShopperDataResponse;
import com.ecom.shoppingex.entity.misc.ProductSortKey;
import com.ecom.shoppingex.entity.shopper.Customer;
import com.ecom.shoppingex.entity.shopper.CustomerSelection;
import com.ecom.shoppingex.repository.CustomerRepository;
import com.ecom.shoppingex.repository.CustomerSelectionRepository;
import com.ecom.shoppingex.service.cache.CacheService;
import com.ecom.shoppingex.specification.repository.ShopperSpecifications;
import com.ecom.shoppingex.specification.request.ShopperRequestSpec;
import com.ecom.shoppingex.util.DtoTransformer;
import com.ecom.shoppingex.util.EntityTranformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopperServiceImpl implements ShopperService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerSelectionRepository customerSelectionRepository;

    @Autowired
    private ShopperSpecifications shopperSpecs;

    @Autowired
    private CacheService cacheService;

    @Override
    public void updateShoppers(List<ShopperData> shoppersData) {
        List<Customer> customers = shoppersData.stream().map(EntityTranformers::buildCustomerEntity).collect(Collectors.toList());
        shoppersData.stream().map(ShopperData::getShopperId).forEach(cacheService::evictCache);
        customerRepository.saveAll(customers);
    }

    @Override
    @Cacheable(value = "shoppers", key =
            "{#requestSpec.shopperId,#requestSpec.category,#requestSpec.brand,#requestSpec.sortOrder,#requestSpec.sortingKey,#requestSpec.offset,#requestSpec.limit}")
    public ShopperDataResponse getShoppersData(ShopperRequestSpec requestSpec) {
        Optional<Specification> specs = buildCriteriaSpecification(requestSpec);
        List<ProductResponse> productList;
        productList =
                customerSelectionRepository.findAll(
                                specs.isPresent() ? specs.get() : null, buildPageable(
                                        requestSpec.getOffset(), requestSpec.getLimit(),
                                        requestSpec.getSortingKey(), requestSpec.getSortOrder()
                                )
                        ).stream()
                        .map(DtoTransformer::buildProductResponse)
                        .collect(Collectors.toList());
        return buildShopperResponseData(requestSpec.getShopperId(), productList);
    }

    private Optional<Specification> buildCriteriaSpecification(ShopperRequestSpec requestSpec) {
        Specification<CustomerSelection> specification = Specification.where((root, query, builder) -> builder.equal(root.get("id").get("customerId"), requestSpec.getShopperId()));
        if (requestSpec.getCategory() != null) {
            specification = specification.and(shopperSpecs.categoryFilter(requestSpec.getCategory()));
        }
        if (requestSpec.getBrand() != null) {
            specification = specification.and(shopperSpecs.brandFilter(requestSpec.getBrand()));
        }
        return Optional.ofNullable(specification);
    }

    private PageRequest buildPageable(int offSet, int limit, ProductSortKey sortingKey, Sort.Direction order) {
        if (sortingKey != null) {
            String property = "product." + sortingKey.name().toLowerCase();
            Sort.Order sortingOrder = Sort.Order.by(property).with(order);
            return PageRequest.of(offSet, limit, Sort.by(sortingOrder));
        } else {
            return PageRequest.of(offSet, limit);
        }
    }

    private static ShopperDataResponse buildShopperResponseData(String customerId, List<ProductResponse> productList) {
        return ShopperDataResponse.builder().customerId(customerId).productList(productList).build();
    }
}
