package com.sankiid.dynamic;

/**
 * Created by sandeep on 23/2/17.
 * <p>
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal
 * to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int val[] = {2, 3, 5};
        int wt[] = {1, 3, 6};
        int W = 7;
        int max = fillKnapsack(val, wt, W);
        System.out.print(max);
    }

    private static int fillKnapsack(int[] val, int[] wt, int W) {
        int[][] tmp = new int[val.length + 1][W + 1];

        for (int j = 1; j <= wt.length; ++j) {
            for (int w = 1; w <= W; ++w) {
                if (wt[j - 1] > w) {
                    tmp[j][w] = tmp[j - 1][w];
                } else {
                    tmp[j][w] = Math.max(tmp[j - 1][w], val[j - 1] + tmp[j - 1][w - wt[j - 1]]);
                }
            }
        }
        return tmp[val.length][W];
    }
}
