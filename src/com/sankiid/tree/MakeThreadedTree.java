package com.sankiid.tree;

import java.util.ArrayList;

/**
 * Created by sandeep on 15/2/17.
 */
public class MakeThreadedTree {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(3);
        root.right = new Node<>(8);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(7);
        root.right.right = new Node<>(11);
        root.right.right.left = new Node<>(9);
        root.right.right.right = new Node<>(13);

        createThreadedBinaryTree(root);
        System.out.println();
    }

    private static void createThreadedBinaryTree(Node<Integer> root) {
        createThreadedBinaryTreeUtils(root, new ArrayList<Node<Integer>>());
    }

    private static void createThreadedBinaryTreeUtils(Node<Integer> root, ArrayList<Node<Integer>> tmp) {
        if(root == null){
            return;
        }
        createThreadedBinaryTreeUtils(root.left, tmp);
        if(tmp.size() > 0){
            tmp.get(0).right = root;
            tmp.get(0).thread = true;
            tmp.remove(0);
        }
        if(root.left == null && root.right == null){
            tmp.add(root);
        }
        createThreadedBinaryTreeUtils(root.right, tmp);
    }
}
