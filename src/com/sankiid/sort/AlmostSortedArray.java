package com.sankiid.sort;

/**
 * Created by sandeep on 14/2/17.
 */
public class AlmostSortedArray {

    public static void main(String[] args) {
        int arr[] = {3, 2, 10, 4, 40};
        int x = 4;
        int result = search(arr, 0, arr.length - 1, x);
        System.out.println(result);
    }

    private static int search(int[] arr, int left, int right, int x) {
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == x) return mid;
        if (mid - 1 >= left && arr[mid - 1] == x) return mid - 1;
        if (mid + 1 <= right && arr[mid + 1] == x) return mid + 1;
        if (arr[mid] < x) {
            return search(arr, mid + 2, right, x);
        }
        return search(arr, left, mid - 2, x);
    }
}
