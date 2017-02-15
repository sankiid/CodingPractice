package com.sankiid.string;

import java.util.List;

/**
 * Created by sandeep on 15/2/17.
 */
public class SuffixTree {

    class Node {
        String data;
        int startIndex;
        boolean end;
        List<Node> childs;
    }

    public Node root;

    public SuffixTree() {
        root = new Node();
    }

    public void insert(String s) {
        if (s != null || s.length() > 0) {
            for (int i = 0; i < s.length(); ++i) {
                String nodeData = root.childs.get(i).data;

            }
        }
    }


    public static void main(String[] args) {
        String text = "this is text message!";
        String pattern = "text";
        SuffixTree tree = new SuffixTree();
        tree.preprocesstext(text);
    }

    private void preprocesstext(String text) {
        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            sb.append(text.charAt(i));
            insert(sb.toString());
        }
    }
}
