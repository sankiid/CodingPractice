package com.design.lrucache;

/**
 * Created by sandeep on 20/2/17.
 */
public class CacheNode<K, V> {
    K key;
    V value;
    CacheNode<K, V> previous;
    CacheNode<K, V> next;

    public CacheNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CacheNode other = (CacheNode) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }
}
