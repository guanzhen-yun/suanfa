package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 排序数组
 */
public class SortArray {

  @Test
  public void main() {
    int[] nums = new int[]{5, 1, 1, 2, 0, 0};
    sortArray(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  public void sortArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }
}
