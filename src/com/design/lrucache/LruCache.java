package com.design.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandeep on 20/2/17.
 */
public class LruCache<K, V> implements ICache<K, V> {


    private CacheNode<K, V> head = null;
    private CacheNode<K, V> tail = null;
    private int capacity = 2000;
    private Map<K, CacheNode<K, V>> cacheMap = null;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<K, CacheNode<K, V>>(capacity);
    }

    @Override
    public synchronized void put(K key, V value) {
        if (this.cacheMap.containsKey(key)) {
            CacheNode<K, V> node = this.cacheMap.get(key);
            remove(node);
            node.value = value;
            add(node);
            this.cacheMap.put(key, node);
        } else {
            if (this.cacheMap.size() >= this.capacity) {
                this.cacheMap.remove(tail.key);
                remove(tail);
            }
            CacheNode<K, V> node = new CacheNode<K, V>(key, value);
            node.key = key;
            node.value = value;
            add(node);
            cacheMap.put(key, node);
        }
    }

    private void add(CacheNode<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    private void remove(CacheNode<K, V> node) {
        if (node.equals(head) && node.equals(tail)) {
            this.head = this.tail = null;
        } else if (node.equals(head)) {
            CacheNode<K, V> next = head.next;
            head.next = null;
            head = next;
            head.previous = null;
        } else if (node.equals(tail)) {
            CacheNode<K, V> prev = tail.previous;
            tail.previous = null;
            tail = prev;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            node.next = node.previous = null;
        }
    }

    @Override
    public synchronized V get(K key) {
        CacheNode<K, V> node = this.cacheMap.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        add(node);
        return node.value;
    }

    @Override
    public synchronized void evictAll() {
        cacheMap.clear();
        if (head != null) {
            head = null;
        }
        if (tail != null) {
            tail = null;
        }
    }

	@Override
	public int size() {
		return cacheMap.size();
	}
}
