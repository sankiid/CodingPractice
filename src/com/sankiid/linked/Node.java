package com.sankiid.linked;

/**
 * Created by sandeep on 11/2/17.
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

}
