package com.sankiid.tree;

import java.util.ArrayList;

/**
 * Created by sandeep on 16/2/17.
 */
public class ChildrenSumTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(2);
        root.right = new Node<>(4);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(1);
        root.right.left = new Node<>(4);
        boolean bool = childrenSumTree(root);
        System.out.print(bool);
    }

    private static boolean childrenSumTree(Node<Integer> root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.data != ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0))) {
            return false;
        }
        return childrenSumTree(root.left) && childrenSumTree(root.right);
    }
}
