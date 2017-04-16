package com.sankiid.array;

import com.sankiid.tree.RedBlackTree;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by sankiid on 11-03-2017. Given input as an integer array and an
 * integer 'k', find and print element with maximum value from each sub-array of
 * size 'k'
 */
public class MaximumInKsubarrays {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 12, 34, 23, 35, 44, 55 };
		int k = 3;
		printLargestInKSize2(arr, k);
	}

	private static void printLargestInKSize(int[] arr, int k) {
		RedBlackTree<Integer> tree = new RedBlackTree<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return (x < y) ? -1 : ((x == y) ? 0 : 1);
			}
		});

		for (int i = 0, j = 0; i < arr.length; ++i) {
			tree.insert(arr[i]);
			j++;
			if (j >= k) {
				tree.printMax();
				tree.delete(arr[i - k]);
			}
		}
	}

	private static void printLargestInKSize2(int[] arr, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < arr.length; ++i) {
			if (i >= k && !list.isEmpty()) {
				System.out.println(arr[list.peekFirst()]);
				if (i - list.peekFirst() >= k - 1) {
					list.removeFirst();
				}
			}
			if (!list.isEmpty() && arr[list.peekLast()] < arr[i]) {
				while (!list.isEmpty() && arr[list.peekLast()] < arr[i]) {
					list.removeLast();
				}
				list.addLast(i);
			} else {
				list.addLast(i);
			}
		}
	}
}
