package com.sankiid.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sankiid on 12-03-2017.
 */
public class DiagonalSum {
    public static void main(String[] args) {
        Node<Integer> root = new Node(0);
        root.left = new Node<>(1);
        root.right = new Node<>(2);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.right.left = new Node<>(7);

        root.right.right = new Node<>(6);
        root.right.left = new Node<>(3);

        Map<Integer, Integer> map = new HashMap<>();
        diagonalSum(root, 0, map);
        for (Integer va : map.values())
            System.out.printf("%d \n", va);
    }

    private static void diagonalSum(Node<Integer> root, int diagonal, Map<Integer, Integer> map) {
        if (root == null) return;
        if (map.containsKey(diagonal)) {
            map.put(diagonal, map.get(diagonal) + root.data);
        } else {
            map.put(diagonal, root.data);
        }
        diagonalSum(root.left, diagonal + 1, map);
        diagonalSum(root.right, diagonal, map);
    }
}
