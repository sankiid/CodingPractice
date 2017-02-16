package com.design.tinyurl;

/**
 * Created by sandeep on 16/2/17.
 */
public class TinyUrlService {
    MappingCache mappingCache = new MappingCache();

    public String generateTinyUrl(String longUrl) {
        String url = new EncoderContext(new Algo1()).encode(longUrl);
        return url;
    }

    /**
     * called with
     */
    public void redirect(String key) {
        MappingCache mappingCache = MappingCache.getMappingCache();
        String longUrl = mappingCache.get(key);
        /*
         *redirect to long url
         */
    }
}
