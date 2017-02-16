package com.sankiid.tree;

import java.util.ArrayList;

/**
 * Created by sandeep on 16/2/17.
 */
public class ChildrenSumTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(3);
        root.right = new Node<>(8);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(7);
        boolean bool = childrenSumTree(root);
        System.out.print(bool);
    }

    private static boolean childrenSumTree(Node<Integer> root) {
        if (root == null) return true;
        
    }
}
