package com.sankiid.sort;

/**
 * Created by sandeep on 17/2/17.
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort ob = new HeapSort();
        ob.sort(arr, arr.length - 1);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    private void sort(int[] arr, int n) {
        for (int i = n; i >= 0; --i) {
            heapify(arr, i, n);
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            n = n - 1;
            heapify(arr, 0, n);
        }
    }

    private void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left <= n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, largest, n);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
