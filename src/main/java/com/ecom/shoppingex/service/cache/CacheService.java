package com.ecom.shoppingex.service.cache;

public interface CacheService {

    void evictCache(String keyPrefix);
}
