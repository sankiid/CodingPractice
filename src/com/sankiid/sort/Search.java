package com.sankiid.sort;

/**
 * Created by sandeep on 12/2/17.
 */
public class Search {

    /**
     * Use it if elements or not ordered.
     * @param arr
     * @param x
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T x) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; ++i) {
            T ar = arr[i];
            if (ar.compareTo(x) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Use it elements are ordered.
     * @param arr
     * @param x
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
        if (arr == null) return -1;
        int start = 0;
        int end = arr.length - 1;
        return binarySearch0(arr, x, start, end);
    }

    private static <T extends Comparable<T>> int binarySearch0(T[] arr, T x, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int comp = arr[mid].compareTo(x);
            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
