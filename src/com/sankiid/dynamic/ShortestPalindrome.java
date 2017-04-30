package com.sankiid.dynamic;

/**
 * Created by sankiid on 13-03-2017.
 */
public class ShortestPalindrome {
	public static void main(String[] args) {
		System.out.println(shortestPal("abab"));
	}

	private static String shortestPal(String s) {
		if (s == null || s.length() == 0)
			return null;
		String rev = new StringBuilder(s).reverse().toString();
		String str = s + rev;
		int[] p = new int[str.length()];
		for (int i = 1; i < str.length(); ++i) {
			int j = p[i - 1];
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = p[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				p[i] = j + 1;
			}
		}
		return rev.substring(0, s.length() - p[str.length() - 1]) + s;
	}
}
