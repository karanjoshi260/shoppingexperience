package com.ecom.shoppingex.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheManager cacheManager;

    public void evictCache(String keyPrefix) {
        Object cache = cacheManager.getCache("shoppers").getNativeCache();
        if (cache instanceof ConcurrentMap<?, ?>) {
            Set<Map.Entry<List<String>, Object>> cacheEntries = ((ConcurrentMap) cache).entrySet();
            cacheEntries.removeIf(cacheEntry -> cacheEntry.getKey().get(0).startsWith(keyPrefix));
        }
    }
}
