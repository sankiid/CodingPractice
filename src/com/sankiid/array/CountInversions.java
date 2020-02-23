package com.sankiid.array;

/**
 * @author sankiid
 */
public class CountInversions {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1, 5, 3, 2, 4, 6};
        int inversions = new CountInversions().countInversionsUtils(arr, 0, arr.length - 1);
        System.out.println(inversions);
    }

    private int countInversionsUtils(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = countInversionsUtils(arr, start, mid);
        int right = countInversionsUtils(arr, mid + 1, end);
        int mergeCount = mergeSplitAndCount(arr, start, mid, end);
        return left + right + mergeCount;
    }

    private int mergeSplitAndCount(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int inversions = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                k++;
                i++;
            } else {
                tmp[k] = arr[j];
                k++;
                j++;
                inversions += (mid - i) + 1;
            }
        }
        while (i <= mid) {
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            tmp[k] = arr[j];
            k++;
            j++;
        }
        for (i = start, k = 0; i < tmp.length + start; ++i, ++k) {
            arr[i] = tmp[k];
        }
        return inversions;
    }

}
