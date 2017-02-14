package com.sankiid.sort;

/**
 * Created by sandeep on 14/2/17.
 */
public class MedianInTwoSortedArray {

    public static void main(String[] args) {
        int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};
        int median = getMedian(ar1, ar2);
        System.out.println(median);
    }

    private static int getMedian(int[] ar1, int[] ar2) {
        return getMedian(ar1, 0, ar1.length - 1, ar2, 0, ar2.length - 1);
    }

    /**
     * This works only if both arrays are of equal size
     *
     * @param ar1
     * @param l1
     * @param r1
     * @param ar2
     * @param l2
     * @param r2
     * @return
     */
    private static int getMedian(int[] ar1, int l1, int r1, int[] ar2, int l2, int r2) {
        if (r1 - l1 + 1 == 2 && r2 - l2 + 1 == 2) {
            return (Math.max(ar1[l1], ar2[l2]) + Math.min(ar1[r1], ar2[r2])) / 2;
        }
        boolean even = (r1-l1+1)%2 == 0;
        int m1 = getMedian(ar1,l1,r1);
        int m2 = getMedian(ar2,l2,r2);
        if (m1 == m2) {
            return m1;
        } else if (m1 > m2) {
            r1 = even ? (l1+r1-1)/2 : (l1+r1)/2;
            l2 = even ? (l2+r2+1)/2 : (l2+r2)/2;
            return getMedian(ar1, l1, r1, ar2, l2, r2);
        } else {
            l1 = even ? (l1+r1-1)/2 : (l1+r1)/2;
            r2 = even ? (l2+r2+1)/2 : (l2+r2)/2;
            return getMedian(ar1, l1, r1, ar2, l2, r2);
        }
    }

    private static int getMedian(int[] ar, int l, int r) {
        if((r-l+1)%2 != 0){
            return ar[(l+r)/2];
        }else{
            return (ar[(l+r-1)/2] + ar[(l+r+1)/2])/2;
        }
    }
}
