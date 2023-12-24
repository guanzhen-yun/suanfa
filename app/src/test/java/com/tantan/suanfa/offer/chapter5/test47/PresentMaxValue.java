package com.tantan.suanfa.offer.chapter5.test47;

import org.junit.Test;

/** 礼物的最大价值 */
public class PresentMaxValue {

  @Test
  public void main() {
    int[][] nums = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
    int maxValue = getMaxValue2(nums);
    System.out.println(maxValue);
  }

  private int getMaxValue(int[][] nums) {
    int[][] maxValues = new int[nums.length][nums[0].length];
    int row = nums.length;
    int column = nums[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        int up = 0;
        int left = 0;
        if (i > 0) {
          up = maxValues[i - 1][j];
        }
        if (j > 0) {
          left = maxValues[i][j - 1];
        }
        maxValues[i][j] = Math.max(up, left) + nums[i][j];
      }
    }
    return maxValues[row - 1][column - 1];
  }

  private int getMaxValue2(int[][] nums) {
    int[] maxValues = new int[nums[0].length];
    int row = nums.length;
    int column = nums[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        int up = 0;
        int left = 0;
        if (i > 0) {
          up = maxValues[j];
        }
        if (j > 0) {
          left = maxValues[j - 1];
        }
        maxValues[j] = Math.max(up, left) + nums[i][j];
      }
    }
    return maxValues[column - 1];
  }
}
