package com.sankiid.linked.dll;

/**
 * Created by sandeep on 17/2/17.
 */
public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
    }
}
