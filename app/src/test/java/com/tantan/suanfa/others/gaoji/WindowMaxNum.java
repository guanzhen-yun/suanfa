package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 滑动窗口最大值
 */
public class WindowMaxNum {

  @Test
  public void main() {
    int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] maxNums = getMaxNums(nums, k);
    for (int i = 0; i < maxNums.length; i++) {
      System.out.print(maxNums[i] + " ");
    }
  }

  private int[] getMaxNums(int[] nums, int k) {
    int[] maxNums = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length - k + 1; i++) {
      maxNums[i] = maxNum(nums, i, k);
    }
    return maxNums;
  }

  private int maxNum(int[] nums, int start, int k) {
    int maxNum = 0;
    for (int i = start; i < start + k; i++) {
      maxNum = Math.max(maxNum, nums[i]);
    }
    return maxNum;
  }
}
