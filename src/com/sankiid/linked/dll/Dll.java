package com.sankiid.linked.dll;

/**
 * Created by sandeep on 17/2/17.
 */
public class Dll<T> {
    public Node<T> head;
    public Node<T> tail;

    public Dll() {
        head = tail = null;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            head.left = node;
            node.right = head;
            head = node;
        }
    }
}
