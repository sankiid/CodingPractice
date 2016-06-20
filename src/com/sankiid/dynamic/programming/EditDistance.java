package com.sankiid.dynamic.programming;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "test";
		String str2 = "tisty";
		int minDistance = findMinDistance(str1, str2);
		System.out.println(minDistance);
	}

	private static int findMinDistance(String str1, String str2) {

		int[][] temp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); ++i) {
			temp[i][0] = i;
		}
		for (int j = 0; j <= str2.length(); ++j) {
			temp[0][j] = j;
		}
		for (int i = 1; i <= str1.length(); ++i) {
			for (int j = 1; j <= str2.length(); ++j) {
				char s1 = str1.charAt(i - 1);
				char s2 = str2.charAt(j - 1);
				if (s1 == s2) {
					temp[i][j] = temp[i - 1][j - 1];
				} else {
					temp[i][j] = Math.min(temp[i - 1][j - 1], Math.min(temp[i - 1][j], temp[i][j - 1])) + 1;
				}
			}
		}

		return temp[str1.length()][str2.length()];
	}

}
