package com.sankiid.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sandeep on 14/2/17.
 */
public class SpiralPrint {
    public static void main(String [] args){
        List<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<Integer>(Arrays.asList(1)));
        a.add(new ArrayList<Integer>(Arrays.asList(2)));
        a.add(new ArrayList<Integer>(Arrays.asList(3)));
        spiralOrder(a);
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int top = 0, bottom = a.size()-1;
        int left = 0, right = a.get(0).size()-1;
        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i=left;i<=right;++i){
                    result.add(a.get(top).get(i));
                }
                dir = 1;top++;
            }else if(dir == 1){
                for(int i=top;i<=bottom;++i){
                    result.add(a.get(i).get(right));
                }
                dir = 2; right--;
            }else if(dir == 2){
                for(int i=right;i>=left;--i){
                    result.add(a.get(bottom).get(i));
                }
                dir=3;bottom--;
            }else{
                for(int i=bottom;i>=top;--i){
                    result.add(a.get(i).get(left));
                }
                dir=0;left++;
            }
        }
        return result;
    }
}
