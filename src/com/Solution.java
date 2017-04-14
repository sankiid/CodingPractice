
package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by sankiid on 05-03-2017.
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		System.out.println(new Solution().convertToTitle(140627));
	}

	public String convertToTitle(int a) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		while (a > 0) {
			list.addLast(a % 26);
			a = a / 26;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < list.size(); ++j) {
			int n = list.get(j);
			if (n == 0 && (j + 1) < list.size()) {
				sb.append('Z');
				Integer i = list.get(j + 1);
				int k = j + 1;
				while (list.get(k).intValue() == 0) {
					k++;
				}
				list.add(k, list.get(k) - 1);
				list.remove(k + 1);
				while (k > j + 1) {
					k--;
					list.add(k, 25);
					list.remove(k + 1);
				}
			} else if (n != 0) {
				sb.append((char) ('A' + n - 1));
			}
		}
		return sb.reverse().toString();
	}

	private static int calculateSum(int n, int m, int sum, int[][] mat, int ii, int jj, int line) {
		while (sum > 0 && (ii < n && jj >= 0 && ii >= 0 && jj < n) && ii + jj == line) {
			sum = getAndSetSum(m, sum, mat, ii, jj);
			sum = getAndSetSum(m, sum, mat, jj, ii);
			ii++;
			jj--;
		}
		return sum;
	}

	private static int getAndSetSum(int m, int sum, int[][] mat, int ii, int jj) {
		if (sum <= 0)
			return 0;
		if (sum > m - 1) {
			mat[ii][jj] += m - 1;
			sum = sum - m + 1;
		} else {
			mat[ii][jj] += sum;
			sum = 0;
		}
		return sum;
	}
}
