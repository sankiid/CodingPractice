
package com;

import java.util.Arrays;

/**
 * Created by sankiid on 05-03-2017.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,1,1,1};//{1, 0, 2, 0, 0, 2};
        int[] tmp = new int[arr.length];
        int i = 0, j = arr.length;
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            Arrays.sort(arr, i, j);
            int k = i;
            int l = 0;
            while (k < j) {
                if (k + 1 == j) {
                    tmp[l] = arr[k];
                } else if (arr[k] == arr[k + 1]) {
                    tmp[l] = arr[k] + 1;
                    k++;
                    repeat = true;
                } else {
                    tmp[l] = arr[k];
                }
                k++;
                l++;
            }
            i = 0;
            j = l;
            arr = tmp;
        }
        System.out.print(j-i);
    }
}
