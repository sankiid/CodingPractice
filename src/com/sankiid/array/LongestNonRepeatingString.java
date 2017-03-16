package com.sankiid.array;

/**
 * Created by sankiid on 11-03-2017.
 */
public class LongestNonRepeatingString {
    public static void main(String[] args) {
        String s = "ABCDABDEFGCABD";
        String out = getSubString(s);
        System.out.print(out);
    }

    private static String getSubString(String s) {
        int size = 26;
        int[] tmp = new int[size];
        tmp[s.charAt(0)-'A'] = 0;
        for (int i = 1; i < size; ++i) {
            tmp[i] = -1;
        }

        int length = 1;
        int maxLength = 1;
        int previous = 0;
        int start = 0;

        for (int j = 1; j < s.length(); ++j) {
            previous = tmp[s.charAt(j)-'A'];
            if(previous == -1 || j - length > previous){
                length++;
            }else {
                if(maxLength < length){
                    maxLength = length;
                    start = j - maxLength;
                }
                length = j - previous;
            }
            tmp[s.charAt(j)-'A'] = j;
        }
        return s.substring(start,start+maxLength);
    }
}
