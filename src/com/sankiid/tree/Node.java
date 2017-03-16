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

    public Node(T e, Node left, Node right) {
        data = e;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void inorder() {
        inorder(this);
    }

    private void inorder(Node<T> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }
}
