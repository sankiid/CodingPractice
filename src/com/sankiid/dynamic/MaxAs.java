package com.sankiid.dynamic;

/**
 * Created by sankiid on 19-03-2017.
 * Let us assume that we have a special keyboard with only the following four keys:
 * Key 1:  Prints 'A' on screen
 * Key 2: (Ctrl-A): Selects screen
 * Key 3: (Ctrl-C): Copy selection to buffer
 * Key 4: (Ctrl-V): Prints buffer on screen appending it after what has already been printed.
 * If you can only press this keyboard for N times, write a program which computes maximum numbers of
 * As possible. That is input for the program is N and output of the program is number indicating maximum
 * As possible.
 */
public class MaxAs {

    public static void main(String[] args) {
        int max = findMaxAs(10);
        System.out.print(max);
    }

    private static int findMaxAs(int n) {
        int[] maxTmp = new int[n + 1];
        for (int j = 1; j <= n; ++j) {
            if (j <= 6) {
                maxTmp[j] = j;
                continue;
            }
            int currentMax = Integer.MIN_VALUE;
            int max = currentMax;
            int multiplier = j - 2;
            for (int i = 1; i < j - 2; ++i) {
                currentMax = Math.max(currentMax, multiplier * maxTmp[i]);
                if (max < currentMax) {
                    max = currentMax;
                }
                multiplier--;
            }
            maxTmp[j] = currentMax;
        }
        return maxTmp[n];
    }
}
