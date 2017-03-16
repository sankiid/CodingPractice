package com.sankiid.array;

/**
 * Created by sankiid on 11-03-2017.
 */
public class KSumArray {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        int k = 7;
        printMinSubArrayWithSum(array, k);
    }

    private static void printMinSubArrayWithSum(int[] arr, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int min_i = Integer.MIN_VALUE, min_j = Integer.MAX_VALUE;
        while (true) {
            if (sum < k) {
                sum += arr[j];
                j++;
            } else if (sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                if (min_j == Integer.MAX_VALUE || (min_j - min_i > j - i-1)) {
                    min_i = i;
                    min_j = j-1;
                }
                if (i < arr.length - 1) {
                    sum -= arr[i];
                    i++;
                }
            }
            if(sum < k && j == arr.length) break;
        }
        System.out.printf("%d, %d", min_i, min_j);
    }
}
