package com.sankiid.array;

/**
 * Created by sankiid on 12-03-2017.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] towerHeight = {
                1, 5, 2, 3, 1, 7, 2, 4
        };
        System.out.println(getMaxRainwaterBetweenTowers(towerHeight));
    }

    private static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
        int[] left = new int[towerHeight.length];
        int[] right = new int[towerHeight.length];
        int max = 0;
        for (int i = 0; i < towerHeight.length; ++i) {
            if (i > 0 && towerHeight[i - 1] > towerHeight[i] && towerHeight[i - 1] > max) {
                max = towerHeight[i - 1];
            }
            left[i] = max;
        }
        max = 0;
        for (int i = towerHeight.length - 1; i >= 0; --i) {
            if (i != towerHeight.length - 1 && towerHeight[i + 1] > towerHeight[i] && towerHeight[i + 1] > max) {
                max = towerHeight[i + 1];
            }
            right[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < towerHeight.length; ++i) {
            if(left[i] < towerHeight[i] && towerHeight[i] >= right[i]){
                sum += Math.max(Math.min(left[i], right[i]) - towerHeight[i], 0);
            }else if(left[i] >= towerHeight[i] && towerHeight[i] < right[i]){
                sum += Math.max(Math.min(left[i], right[i]) - towerHeight[i], 0);
            }
        }
        return sum;
    }
}
