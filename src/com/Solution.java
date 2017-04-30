
package com;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by sankiid on 05-03-2017.
 */
public class Solution {

    private HashMap<Integer,Integer> map = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private int cap;
    public Solution(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        Integer k = new Integer(key);
        if(map.containsKey(k)) {
            Integer value = map.get(k);
            list.remove(k);
            list.addFirst(k);
            return value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        Integer k = new Integer(key);
        if(map.containsKey(k)){
            list.remove(k);
            list.addFirst(k);
            map.put(k, value);
        } else {
            if(list.size() >= cap){
                map.remove(list.removeLast());
            }
            list.addFirst(k);
            map.put(k, value);
        }
    }
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution(1);
		solution.set(2, 1);
		System.out.println(solution.get(2));
		solution.set(3, 2);
		System.out.println(solution.get(2));
		System.out.println(solution.get(3));
		
	}
}
