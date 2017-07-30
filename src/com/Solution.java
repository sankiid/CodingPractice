
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sankiid on 05-03-2017.
 */

public class Solution {

	public static void main(String args[]) throws Exception {
	    Map<String, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(-19, 8, 2, -8, 19, 5, -2, -23));
		ArrayList<Integer> list = new Solution().lszero(a);
		list.stream().forEach(e -> System.out.printf("%d, ", e));
	}

	public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < a.size(); ++i) {
			sum += a.get(i);
			if (sum == 0 || map.containsKey(sum)) {
				if(sum == 0 && !map.containsKey(sum)){
			        map.put(sum, -1);
			    }
				if (i - map.get(sum) > max) {
					index = i;
					max = i - map.get(sum);
				}
			} else {
				map.put(sum, i);
			}
		}
		if (index == -1) {
			return null;
		}
		return new ArrayList<>(a.subList(index - max + 1, index + 1));
	}
}
