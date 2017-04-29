package com.sankiid.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sankiid on 11-03-2017.
 */
public class Permutations {
	public static void main(String[] args) {
		String s = "aabc";
		Set<String> p = permutations(s);
		for (String ss : p) {
			System.out.println(ss);
		}

		printPermutations("aabc".toCharArray());
	}

	private static void printPermutations(char[] arr) {
		Arrays.sort(arr);
		List<Integer> count = new ArrayList<>();
		List<Character> chars = new ArrayList<>();
		count.add(1);
		chars.add(arr[0]);
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] == arr[i - 1]) {
				count.set(i - 1, count.get(i - 1) + 1);
			} else {
				count.add(1);
				chars.add(arr[i]);
			}
		}
		System.out.println("----------------------------------------");
		for (int i = 1; i <= chars.size(); ++i) {
			int size = getSize(count.subList(0, i));
			permutationUtils(chars.subList(0, i), count.subList(0, i), new char[size], 0);
		}
	}

	private static int getSize(List<Integer> subList) {
		int s = 0;
		for (Integer i : subList) {
			s += i;
		}
		return s;
	}

	private static void permutationUtils(List<Character> chars, List<Integer> count, char[] sb, int idx) {
		if (idx == sb.length) {
			System.out.println(sb);
		} else {
			for (int i = 0; i < chars.size(); ++i) {
				if (count.get(i) != 0) {
					sb[idx] = chars.get(i);
					count.set(i, count.get(i) - 1);
					permutationUtils(chars, count, sb, idx + 1);
					count.set(i, count.get(i) + 1);
				}
			}
		}
	}

	private static Set<String> permutations(String s) {
		Set<String> p = new HashSet<>();
		if (s == null || s.length() == 0) {
			p.add("");
			return p;
		}
		char c = s.charAt(0);
		String ss = s.substring(1);
		Set<String> per = permutations(ss);
		for (String pr : per) {
			for (int i = 0; i <= pr.length(); ++i) {
				String prefix = pr.substring(0, i);
				String postfix = pr.substring(i);
				p.add(prefix + c + postfix);
			}
		}
		return p;
	}
}
