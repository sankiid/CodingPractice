package com.sankiid.tree;

/**
 * Created by sandeep on 15/2/17.
 */
public class Node<T> {

    public T data;
    public Node<T> left;
    public Node<T> right;
    public boolean thread;

    public Node() {
    }
    public Node(T e) {
        data = e;
        left = null;
        right = null;
    }
}
