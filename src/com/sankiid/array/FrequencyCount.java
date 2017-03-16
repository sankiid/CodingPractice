package com.sankiid.array;

/**
 * Created by sankiid on 11-03-2017.
 * Given an array of length n having integers 1 to n with some elements being repeated.
 * Count frequencies of all elements from 1 to n.
 */
public class FrequencyCount {
    public static void main(String[] arsg) {
        int[] arr = {2, 3, 3, 2, 5};
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            arr[i] -= 1;
        }
        for (int i = 0; i < n; ++i) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }
        for (int i = 0; i < n; ++i) {
            System.out.printf("%d %d\n", i + 1, arr[i] / n);
            arr[i] = arr[i] % n + 1;
        }
    }
}
