package com.sankiid.sort;

/**
 * Created by sandeep on 14/2/17.
 */
public class KClosest {

    public static void main(String[] args) {
        findKClosest();
    }

    private static void findKClosest() {
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56
        };
        int x = 36, k = 4;
        int left = findCrossOverPoint(arr, 0, arr.length - 1, x);
        int right = left + 1;
        if (arr[left] == x)
            left--;
        if (arr[right] == x)
            right++;
        while (left >= 0 && right < arr.length && k > 0) {
            if (x - arr[left] > arr[right] - x) {
                System.out.println(arr[right]);
                right++;
            } else {
                System.out.println(arr[left]);
                left--;
            }
            k--;
        }
        while (left >= 0 && k > 0) {
            System.out.println(arr[left]);
            left--;
            k--;
        }
        while (right < arr.length && k > 0) {
            System.out.println(arr[right]);
            right++;
            k--;
        }

    }

    private static int findCrossOverPoint(int[] arr, int left, int right, int x) {
        int mid = (left + right) / 2;
        if (arr[mid] == x || (mid + 1 <= right && arr[mid] < x && arr[mid + 1] > x)
                || (mid - 1 >= left && arr[mid] > x && arr[mid - 1] < x)) {
            return mid;
        } else if (arr[mid] > x) {
            return findCrossOverPoint(arr, left, mid - 1, x);
        } else {
            return findCrossOverPoint(arr, mid + 1, right, x);
        }
    }
}
