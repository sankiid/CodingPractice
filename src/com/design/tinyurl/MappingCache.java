package com.design.tinyurl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandeep on 16/2/17.
 */
public class MappingCache {
    private Map<String, String> cache = new HashMap<>();

    private static MappingCache mappingCache = new MappingCache();

    public static MappingCache getMappingCache(){
        return mappingCache;
    }

    public void put(String key, String longUrl) {
        cache.put(key, longUrl);
    }

    public String get(String key) {
        return cache.get(key);
    }

}
