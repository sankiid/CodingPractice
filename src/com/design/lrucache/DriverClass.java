package com.design.lrucache;

/**
 * Created by sandeep on 20/2/17.
 */
public class DriverClass {
    public static void main(String[] args) {
        ICache<Integer, String> cache = new LruCache<>(5);
        cache.put(1, "test-1");
        cache.put(2, "test-2");
        System.out.println(cache.getValue(1));
        System.out.println(cache.getValue(3));
        cache.put(3, "test-3");
        cache.put(4, "test-4");
        cache.put(5, "test-5");
        cache.put(6, "test-6");
        cache.put(5, "test-10");
        System.out.println(cache.getValue(6));
        System.out.println(cache.getValue(2));
        System.out.println(cache.getValue(5));
    }
}
