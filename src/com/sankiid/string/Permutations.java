package com.sankiid.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sankiid on 11-03-2017.
 */
public class Permutations {
    public static void main(String[] args) {
        String s = "abc";
        Set<String> p = permutations(s);
        for (String ss : p) {
            System.out.println(ss);
        }
    }

    private static Set<String> permutations(String s) {
        Set<String> p = new HashSet<>();
        if (s == null || s.length() == 0) {
            p.add("");
            return p;
        }
        char c = s.charAt(0);
        String ss = s.substring(1);
        Set<String> per = permutations(ss);
        for (String pr : per) {
            for (int i = 0; i <= pr.length(); ++i) {
                String prefix = pr.substring(0, i);
                String postfix = pr.substring(i);
                p.add(prefix + c + postfix);
            }
        }
        return p;
    }
}
