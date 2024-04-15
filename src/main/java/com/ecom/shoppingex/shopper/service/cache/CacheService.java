package com.ecom.shoppingex.shopper.service.cache;

public interface CacheService {

    void evictCache(String keyPrefix);
}
