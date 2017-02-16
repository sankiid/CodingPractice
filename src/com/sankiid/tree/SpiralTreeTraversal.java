package com.sankiid.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sandeep on 16/2/17.
 * 6
 * / \
 * 3   8
 * /\   /
 * 1  5  7
 */
public class SpiralTreeTraversal {
    public static void main(String[] args) {
        Node<Integer> root1 = new Node<>(6);
        root1.left = new Node<>(3);
        root1.right = new Node<>(8);
        root1.left.left = new Node<>(1);
        root1.left.right = new Node<>(5);
        root1.right.left = new Node<>(7);
        root1.right.right = new Node<>(10);
        printSpiral(root1);
    }

    private static void printSpiral(Node<Integer> root) {
        if (root == null)
            return;
        Node<Integer> dummy = new Node<Integer>(Integer.MIN_VALUE);
        Queue<Node<Integer>> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        queue.add(dummy);
        boolean left = true;
        while (!queue.isEmpty()) {
            Node<Integer> e = queue.remove();
            if (e.data != Integer.MIN_VALUE) {
                System.out.print(e.data + " ");
                if (left) {
                    if (e.left != null) {
                        queue.add(e.left);
                    }
                    if (e.right != null) {
                        queue.add(e.right);
                    }
                } else {
                    if (e.right != null) {
                        queue.add(e.right);
                    }
                    if (e.left != null) {
                        queue.add(e.left);
                    }
                }
            } else {
                if (!queue.isEmpty()) {
                    left = !left;
                    queue.add(dummy);
                }
            }
        }
    }
}
