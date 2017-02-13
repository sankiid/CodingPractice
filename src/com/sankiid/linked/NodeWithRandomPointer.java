package com.sankiid.linked;

/**
 * Created by sandeep on 11/2/17.
 */
public class NodeWithRandomPointer<T> {

    public T data;
    public NodeWithRandomPointer<T> next;
    public NodeWithRandomPointer<T> random;

    public NodeWithRandomPointer(T data){
        this.data = data;
        this.next = null;
        this.random = null;
    }

    public NodeWithRandomPointer(T data, NodeWithRandomPointer<T> next){
        this.data = data;
        this.next = next;
        this.random = null;
    }

    public NodeWithRandomPointer(T data, NodeWithRandomPointer<T> next, NodeWithRandomPointer<T> random){
        this.data = data;
        this.next = next;
        this.random = random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeWithRandomPointer<?> that = (NodeWithRandomPointer<?>) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return next != null ? next.equals(that.next) : that.next == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
