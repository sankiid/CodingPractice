package com.sankiid.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintViews {

    static class Entry {
        int data;
        int level;

        public Entry(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(2);
        root.right = new Node<>(4);
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(11);
        root.right.left = new Node<>(40);
        root.left.left.left = new Node<>(15);
        System.out.println("printing right view");
        printRightView(root, 0, new int[]{-1});
        System.out.println("printing left view");
        printLeftView(root, 0, new int[]{-1});
        System.out.println("printing top view");
        Map<Integer, Entry> map = new HashMap<Integer, Entry>();
        printTopView(root, 0, 0, map);
        for (Entry e : map.values()) {
            System.out.println(e.data);
        }
        System.out.println("printing bottom view");
        Map<Integer, Entry> bmap = new HashMap<Integer, Entry>();
        printBottomView(root, 0, 0, bmap);
        for (Entry e : bmap.values()) {
            System.out.println(e.data);
        }
        Map<Integer, List<Integer>> vertical = new HashMap<>();
        printVerticalOrder(root, 0, 0, vertical);
        for (Map.Entry<Integer, List<Integer>> e : vertical.entrySet()) {
            System.out.println();
            for (Integer i : e.getValue()) {
                System.out.printf("%d ", i);
            }
        }
    }

    private static void printVerticalOrder(Node<Integer> root, int level, int direction, Map<Integer, List<Integer>> vertical) {
        if (root == null) return;
        if (vertical.containsKey(direction)) {
            vertical.get(direction).add(root.data);
        } else {
            List<Integer> list = new LinkedList<>();
            list.add(root.data);
            vertical.put(direction, list);
        }
        printVerticalOrder(root.left, level + 1, direction - 1, vertical);
        printVerticalOrder(root.right, level + 1, direction + 1, vertical);
    }

    private static void printBottomView(Node<Integer> root, int level,
                                        int direction, Map<Integer, Entry> map) {
        if (root == null)
            return;
        if (map.containsKey(direction)) {
            if (map.get(direction).level < level) {
                map.put(direction, new Entry(root.data, level));
            }
        } else {
            Entry entry = new Entry(root.data, level);
            map.put(direction, entry);
        }
        printBottomView(root.left, level + 1, direction - 1, map);
        printBottomView(root.right, level + 1, direction + 1, map);
    }

    private static void printTopView(Node<Integer> root, int level,
                                     int direction, Map<Integer, Entry> map) {
        if (root == null)
            return;
        if (map.containsKey(direction)) {
            if (map.get(direction).level > level) {
                map.put(direction, new Entry(root.data, level));
            }
        } else {
            Entry entry = new Entry(root.data, level);
            map.put(direction, entry);
        }
        printTopView(root.left, level + 1, direction - 1, map);
        printTopView(root.right, level + 1, direction + 1, map);
    }

    private static void printLeftView(Node<Integer> root, int level,
                                      int[] maxLevel) {
        if (root == null)
            return;
        if (level > maxLevel[0]) {
            System.out.println(root.data);
            maxLevel[0] = level;
        }
        printLeftView(root.left, level + 1, maxLevel);
        printLeftView(root.right, level + 1, maxLevel);
    }

    private static void printRightView(Node<Integer> root, int level,
                                       int[] maxLevel) {
        if (root == null)
            return;
        if (level > maxLevel[0]) {
            System.out.println(root.data);
            maxLevel[0] = level;
        }
        printRightView(root.right, level + 1, maxLevel);
        printRightView(root.left, level + 1, maxLevel);
    }

}
