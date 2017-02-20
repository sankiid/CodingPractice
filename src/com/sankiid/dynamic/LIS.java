package com.sankiid.dynamic;

/**
 * Created by sandeep on 20/2/17.
 * <p>
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
 * sequence such that all elements of the subsequence are sorted in increasing order. For example, the length
 * of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {

    public static void main(String args[]) {
        int arr[] = {11, 22, 9, 33, 21, 50, 41, 60, 80, 5};
        System.out.println("\nLength of LIS is " + lis(arr));
    }

    private static int lis(int[] arr) {
        if (arr == null) return 0;
        int[] tmp = new int[arr.length];
        tmp[0] = 1;
        int lis = tmp[0];
        int lisIndex = 0;
        for (int i = 1; i < arr.length; ++i) {
            int max = 0;
            int j = i - 1;
            while (j >= 0) {
                if (arr[i] > arr[j]) {
                    if (max < tmp[j]) {
                        max = tmp[j];
                    }
                }
                j--;
            }
            tmp[i] = 1 + max;
            lis = lis > tmp[i] ? lis : tmp[i];
            lisIndex = lis > tmp[i] ? lisIndex : i;
        }
        int t = tmp[lisIndex];
        System.out.print(arr[lisIndex]);
        while (lisIndex >= 0) {
            if ((t - 1) == tmp[lisIndex]) {
                System.out.print(" " + arr[lisIndex]);
                t = tmp[lisIndex];
            }
            lisIndex--;
        }
        return lis;
    }
}