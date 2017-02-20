package com.sankiid.array;

/**
 * Created by sandeep on 20/2/17.
 * <p>
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all
 * the elements to its right side. And the rightmost element is always a leader. For example int the
 * array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class Leader {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        printLeaders(arr);
    }

    private static void printLeaders(int[] arr) {
        if (arr == null) return;
        int n = arr.length - 1;
        int currentLeader = arr[n];
        System.out.print(currentLeader);
        for (int i = n - 1; i >= 0; --i) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                System.out.print(" " + currentLeader);
            }
        }
    }
}
