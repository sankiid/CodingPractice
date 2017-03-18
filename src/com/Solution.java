
package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sankiid on 05-03-2017.
 */
public class Solution {


    TrieNode root;

    public Solution() {
        this.root = new TrieNode('\0');
    }

    public void add(String name) {
        add(this.root, name, 0);
    }

    public void add(TrieNode node, String name, int idx) {
        if (idx == name.length()) {
            node.isEnd = true;
            return;
        }
        char c = name.charAt(idx);
        int id = c - 'a';
        if (node.child[id] == null) {
            node.child[id] = new TrieNode(c);
        }
        add(node.child[id], name, idx + 1);
    }

    public void find(String name) {
        find(this.root, name, 0);
    }

    public void find(TrieNode node, String name, int idx) {
        if (idx == name.length()) {
            int[] count = new int[1];
            count[0] = 0;
            coundWords(node, count);
            System.out.println(count[0]);
            return;
        }
        char c = name.charAt(idx);
        int id = c - 'a';
        if (node.child[id] == null) {
            System.out.println(0);
            return;
        } else {
            if (idx < name.length()) {
                find(node.child[id], name, idx + 1);
            }
        }
    }

    public void coundWords(TrieNode node, int[] count) {
        if (node == null) return;
        if (node.isEnd) {
            count[0]++;
        }
        for (TrieNode nd : node.child) {
            coundWords(nd, count);
        }
    }


    public class TrieNode {
        char c;
        TrieNode[] child;
        boolean isEnd;

        public TrieNode(char c) {
            this.c = c;
            this.child = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        Solution solv = new Solution();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String[] token = br.readLine().split("[ ]");
                String opt = token[0];
                String name = token[1];
                switch (opt) {
                    case "add":
                        solv.add(name);
                        break;
                    case "find":
                        solv.find(name);
                        break;
                }
            }
            br.close();
        } catch (Exception e) {

        }
    }
}
