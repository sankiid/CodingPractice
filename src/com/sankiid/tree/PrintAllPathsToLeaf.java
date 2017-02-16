package com.sankiid.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep on 16/2/17.
 */
public class PrintAllPathsToLeaf {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(3);
        root.right = new Node<>(8);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(7);
        printAllPathsToLeaf(root, new ArrayList<String>());
    }

    private static void printAllPathsToLeaf(Node<Integer> root, List<String> path) {
        if (root == null)
            return;

        path.add(root.data.toString());
        if (root.left == null && root.right == null) {
            for (String s : path) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        printAllPathsToLeaf(root.left, path);
        printAllPathsToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }
}
