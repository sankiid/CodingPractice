package com.sankiid.array;

/**
 * Created by sandeep on 20/2/17.
 */
public class Celebrity {
    private static boolean MATRIX[][] = {
            {false, false, true, false},
            {false, false, true, false},
            {false, false, false, false},
            {false, false, true, false}
    };

    public static boolean knows(int a, int b) {
        return MATRIX[a][b];
    }

    public static void main(String[] args) {
        int n = 4;
        int id = findCelebrity(n);
        if (id == -1) {
            System.out.print("No celebrity");
        } else {
            System.out.print("celebrity is " + id);
        }
    }

    private static int findCelebrity(int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (knows(i, j)) {
                i++;
            } else {
                j--;
            }
        }
        for (int k = 0; k < n; ++k) {
            if ((k != i) && (!knows(k, i) || knows(i, k))) {
                return -1;
            }
        }
        return i;
    }
}
