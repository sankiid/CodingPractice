package com.design.lrucache;

import java.util.LinkedHashMap;

public class LRUJavaCache<K, V> extends LinkedHashMap<K, V> {

	private static final long	serialVersionUID	= 63730476421632905L;
	private int					totalSize;

	public LRUJavaCache(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor, true);
		this.totalSize = initialCapacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		if (this.size() > this.totalSize) {
			return true;
		}
		return false;
	}
}
