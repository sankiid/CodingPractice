package com.sankiid.sort;

/**
 * Created by sandeep on 14/2/17.
 */
public class KthElementInUnsortedArray {

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        int pos = kthSmallest(arr, 0, arr.length - 1, k);
        System.out.println(pos);
    }

    private static int kthSmallest(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);
            if (pivot - left == k - 1) {
                return arr[pivot];
            } else if (pivot - left > k - 1) {
                return kthSmallest(arr, left, pivot - 1, k);
            } else {
                return kthSmallest(arr, pivot + 1, right, k - pivot + left - 1);
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int left, int right) {
        int partionar = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[i] <= partionar && i < right) {
                i++;
            }
            while (arr[j] >= partionar && j > left) {
                j--;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[left] = arr[j];
        arr[j] = partionar;
        return j;
    }
}
