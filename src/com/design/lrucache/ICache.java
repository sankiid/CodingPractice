package com.design.lrucache;

/**
 * Created by sandeep on 20/2/17.
 */
public interface ICache<K, V> {

    public void put(K key, V value);

    public V get(K key);
    
    public int size();

    public void evictAll();
}
