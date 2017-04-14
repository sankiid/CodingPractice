package com.sankiid.dynamic;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sankiid on 13-03-2017.
 */
public class WordBreak {

	private static HashSet<String> dictonary = new HashSet<>();

	static {
		String[] arr = { "arrays", "dynamic", "heaps", "ID", "IDeserve", "learn", "learning", "linked", "list",
				"platform", "programming", "stacks", "trees" };
		dictonary.addAll(Arrays.asList(arr));
	}

	public static void main(String[] args) {
		if (hasValidWords("IDeservelearningplatform"))
			System.out.println("true");
		else
			System.out.println("false");
	}

	private static boolean hasValidWords(String words) {
		if (words == null || words.length() <= 0)
			return false;
		boolean[] valid = new boolean[words.length()];
		for (int i = 0; i < words.length(); ++i) {
			String s = words.substring(0, i + 1);
			if (dictonary.contains(s)) {
				valid[i] = true;
			}
			if (valid[words.length() - 1]) {
				return true;
			}
			if (valid[i]) {
				for (int j = i + 1; j < words.length(); ++j) {
					String s1 = words.substring(i + 1, j + 1);
					if (dictonary.contains(s1)) {
						valid[j] = true;
					}
					if (valid[words.length() - 1]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
