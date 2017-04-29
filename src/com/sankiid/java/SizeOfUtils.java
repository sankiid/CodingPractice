package com.sankiid.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SizeOfUtils {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("d"));
	}

	public static int lengthOfLastWord(final String a) {
	    if(a == null || a.length() == 0) return 0;
	    int count = 0;
	    int j = a.length()-1;
	    
	    while(j >= 0 && a.charAt(j) == ' ') j--;
	    
	    while(j>=0){
	        if(a.charAt(j) != ' '){
	            count++;
	        }else{
	          break;  
	        }
	        j--;
	    }
	    return count;
	}
}
