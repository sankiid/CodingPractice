package com.design.tinyurl;

/**
 * Created by sandeep on 16/2/17.
 */
public class Algo1 implements Encoder {
    private MappingCache mappingCache = MappingCache.getMappingCache();
    @Override
    public String encode(String key) {
        String v = "";
        mappingCache.put(v, key);
        return v;
    }
}
