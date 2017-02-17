package com.sankiid.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sandeep on 17/2/17.
 */
public class LCA {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(3);
        root.right = new Node<>(8);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(7);
        root.right.right = new Node<>(10);
        System.out.println(findLca(root, 1, 10));
        System.out.println(findLca(root, 3, 5));

        Present present = new Present();
        Node<Integer> node = findLcaBuggy(root, 3, 5, present);
        System.out.println(present.v1 && present.v2 ? node : null);

        present = new Present();
        node = findLcaBuggy(root, 100, 10, present);
        System.out.println(present.v1 && present.v2 ? node : null);
    }

    private static Node<Integer> findLcaBuggy(Node<Integer> root, int n1, int n2, Present present) {
        if (root == null) return null;

        if (root.data == n1) {
            present.v1 = true;
            return root;
        }
        if (root.data == n2) {
            present.v2 = true;
            return root;
        }
        Node left = findLcaBuggy(root.left, n1, n2, present);
        Node right = findLcaBuggy(root.right, n1, n2, present);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private static Integer findLca(Node<Integer> root, int n1, int n2) {
        List<Integer> paths = new LinkedList<>();
        List<List<Integer>> allPaths = new LinkedList<>();
        findAllPaths(root, paths, allPaths);
        List<Integer> path1 = findDataPath(allPaths, n1);
        List<Integer> path2 = findDataPath(allPaths, n2);
        if (path1 != null && path2 != null) {
            int size = path1.size() > path2.size() ? path2.size() : path1.size();
            for (int i = 0; i < size; ++i) {
                if (path1.get(i) == n1 || path2.get(i) == n2)
                    return path1.get(i) == n1 ? n1 : n2;
                if (path1.get(i) == path2.get(i))
                    continue;
                return path1.get(i - 1);
            }
        }
        return null;
    }

    private static List<Integer> findDataPath(List<List<Integer>> allPaths, int n) {
        for (List<Integer> paths : allPaths) {
            if (paths.contains(n)) {
                return paths;
            }
        }
        return null;
    }

    private static void findAllPaths(Node<Integer> root, List<Integer> paths, List<List<Integer>> allPaths) {
        if (root == null) return;
        paths.add(root.data);
        if (root.left == null && root.right == null) {
            List<Integer> list = new LinkedList<>();
            for (Integer path : paths) {
                list.add(path);
            }
            allPaths.add(list);
        }
        findAllPaths(root.left, paths, allPaths);
        findAllPaths(root.right, paths, allPaths);
        paths.remove(paths.size() - 1);
    }

    static class Present {
        Boolean v1 = Boolean.FALSE;
        Boolean v2 = Boolean.FALSE;
    }
}
