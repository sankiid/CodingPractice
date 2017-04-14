package com.sankiid.sort;

import java.util.*;

/**
 * Created by sandeep on 12/2/17.
 */
public class SortUtils {

    public static <T extends Comparable<T>> void bubbleSort(T[] ele) {
        int n = ele.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (ele[j].compareTo(ele[j + 1]) > 0) {
                    T tmp = ele[j];
                    ele[j] = ele[j + 1];
                    ele[j + 1] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] ele) {
        int n = ele.length;
        for (int i = 0; i < n - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (ele[j].compareTo(ele[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T tmp = ele[i];
            ele[i] = ele[minIndex];
            ele[minIndex] = tmp;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T ele = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(ele) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = ele;
        }
    }

    /**
     * Time complexity is nlog(n)
     * This is not stable sorting
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
        T partionar = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[i].compareTo(partionar) <= 0 && i < end) {
                i++;
            }
            while (arr[j].compareTo(partionar) >= 0 && j > start) {
                j--;
            }
            if (i < j) {
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[start] = arr[j];
        arr[j] = partionar;
        return j;
    }

    /**
     * Time complexity is nlog(n)
     * This is stable sorting
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        Object[] tmp = new Object[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (true) {
            if (i <= mid && j <= end && arr[i].compareTo(arr[j]) <= 0) {
                tmp[k] = arr[i];
                i++;
                k++;
            } else if (i <= mid && j <= end && arr[i].compareTo(arr[j]) > 0) {
                tmp[k] = arr[j];
                j++;
                k++;
            } else if (i <= mid) {
                tmp[k] = arr[i];
                i++;
                k++;
            } else if (j <= end) {
                tmp[k] = arr[j];
                j++;
                k++;
            } else {
                break;
            }
        }
        for (int ii = start; ii <= end; ++ii) {
            arr[ii] = (T) tmp[ii - start];
        }
    }

    public static void countingSort(int[] arr, int range) {
        int[] tmp = new int[arr.length];
        int[] count = new int[range];
        for (int i = 0; i < arr.length; ++i) {
            count[arr[i]] += 1;
        }
        for (int i = 1; i < range; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            tmp[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = tmp[i];
        }
    }

    /**
     * Time complexity is (n+range)
     *
     * @param arr
     */
    public static void countingSortWithNegativeNumbers(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
        }
        if (min < 0) {
            min = -1 * min;
            for (int i = 0; i < arr.length; ++i) {
                arr[i] += min;
            }
            countingSort(arr, max + min + 1);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] -= min;
            }
        } else {
            countingSort(arr, max + 1);
        }
    }


    public static void bucketSort(float[] arr) {
        Map<Integer, List<Float>> buckets = new TreeMap<Integer, List<Float>>();

        for (int i = 0; i < arr.length; ++i) {
            Integer key = (int) (arr.length * arr[i]);
            if (buckets.get(key) == null) {
                buckets.put(key, new LinkedList<Float>());
            }
            buckets.get(key).add(arr[i]);
        }
        for (Map.Entry<Integer, List<Float>> entry : buckets.entrySet()) {
            List<Float> number = entry.getValue();
            if (number != null && !number.isEmpty()) {
                Float[] num = number.toArray(new Float[number.size()]);
                insertionSort(num);
                buckets.put(entry.getKey(), Arrays.asList(num));
            }
        }
        int j = 0;
        for (Map.Entry<Integer, List<Float>> entry : buckets.entrySet()) {
            List<Float> number = entry.getValue();
            if (number != null && !number.isEmpty()) {
                for (Float f : number)
                    arr[j++] = f;
            }
        }
    }

    public static void main(String[] ar) {
//        int [] arr  = {-4,-5,-4,2,0,3,1};
//        int[] arr = {4, 5, 4, 2, 0, 3, 1};
//        countingSortWithNegativeNumbers(arr);
//        System.out.println();

//        float [] ft = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
//        bucketSort(ft);

        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        radixsort(arr);
        System.out.println();
    }

    public static void radixsort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            max = max < arr[i] ? arr[i] : max;
        }
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort2(arr, i);
        }
    }

    private static void countingSort2(int[] arr, int exp) {
    	int range = 10;
        int[] tmp = new int[arr.length];
        int[] count = new int[range];
        for (int i = 0; i < arr.length; ++i) {
            count[(arr[i] / exp) % 10] += 1;
        }
        for (int i = 1; i < range; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            tmp[count[(arr[i] / exp) % 10] - 1] = arr[i];
            --count[(arr[i] / exp) % 10];
        }
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = tmp[i];
        }
    }

}
