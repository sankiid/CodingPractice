package com.sankiid.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sandeep on 17/2/17.
 * this is for getting the all staff count in peak hours in customer support
 * start and end array represnt call durations
 */
public class FindStaffRequired {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int calls = Integer.parseInt(br.readLine());
        long[] start = new long[calls];
        long[] end = new long[calls];
        for (int i = 0; i < calls; ++i) {
            String[] token = br.readLine().split("[ ]");
            start[i] = Long.parseLong(token[0]);
            end[i] = Long.parseLong(token[1]);
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int staffReq = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int count = 0;
        while (i < start.length && j < end.length) {
            if (start[i] > end[j]) {
                count--;
                j++;
            } else if (start[i] < end[j]) {
                count++;
                i++;
            }
            if (staffReq < count) {
                staffReq = count;
            }
        }
        System.out.printf("%d", staffReq);
    }
}
