package com.sankiid.tree;

import java.util.Stack;

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
        Stack<Node<Integer>> stack1 = new Stack<>();
        Stack<Node<Integer>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node<Integer> e = stack1.pop();
                System.out.print(e.data + " ");
                if (e.right != null)
                    stack2.push(e.right);
                if (e.left != null)
                    stack2.push(e.left);
            }
            while (!stack2.isEmpty()) {
                Node<Integer> e = stack2.pop();
                System.out.print(e.data + " ");
                if (e.left != null)
                    stack1.push(e.left);
                if (e.right != null) {
                    stack1.push(e.right);
                }
            }
        }
    }

}
