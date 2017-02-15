package com.sankiid.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandeep on 15/2/17.
 */
public class FindRepeateAndMissing {

    public static void main(String[] args) {
        findRepeateAndMissing(Arrays.asList(3, 1, 2, 5, 3));
    }

    private static void findRepeateAndMissing(List<Integer> a) {
        int n = a.size();
        int x = 0;
        for (int i = 0; i < n; ++i) {
            x ^= (a.get(i) ^ (i + 1));
        }
        int xx = 1;
        while ((x & 1) == 0) {
            x = x >> 1;
            xx = xx << 1;
        }
        int set1 = 0, set2 = 0;
        for (int i = 0; i < a.size(); ++i) {
            if ((a.get(i).intValue() & xx) == 0) {
                set1 ^= a.get(i).intValue();
            } else {
                set2 ^= a.get(i).intValue();
            }
            if (((i + 1) & xx) == 0) {
                set1 ^= (i + 1);
            } else {
                set2 ^= (i + 1);
            }
        }
        System.out.println(set1);
        System.out.println(set2);
    }

}
