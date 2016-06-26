package com.sankiid.string;

public class KMPStringMatch {

	public static void main(String[] args) {
		String text = "abcxabcdbaxabcdabcdabcas";
		String pattern = "abcdabca";
//		String pattern = "aabaabaaa";

		int index = findStringMatch(text, pattern);
		System.out.println(index);
	}

	private static int findStringMatch(String text, String pattern) {

		int[] temp = compilePattern(pattern);
		return 0;
	}

	private static int[] compilePattern(String pattern) {
		int[] temp = new int[pattern.length()];
		temp[0] = 0;

		int j = 0, i = 1, k = 1;
		while (true) {
			if (j >= pattern.length() || i >= pattern.length()) {
				break;
			}
			char x = pattern.charAt(j);
			char y = pattern.charAt(i);
			if (x == y) {
				temp[k++] = j + 1;
				j++;
				i++;
			} else {
				if (j - 1 < 0) {
					temp[k++] = 0;
					i++;
				} else {
					j = temp[j - 1];
				}
			}
		}

		return temp;
	}

}
