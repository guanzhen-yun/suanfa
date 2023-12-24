package com.tantan.suanfa.offer.chacter2.test3;

import org.junit.Test;

/**
 * 数组中重复的数字 找出数组中重复的数字 数组中数字不大于数组长度 数组会发生变化
 */
public class ChongfuNumInArray {

  @Test
  public void main() {
    int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
    System.out.println(findDuplicateNum(nums));
  }

  private int findDuplicateNum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      if (nums[i] < 0 || nums[i] > length) {
        return -1;
      }
    }

    for (int i = 0; i < length; i++) {
      while (i != nums[i]) {
        if (nums[i] == nums[nums[i]]) {
          return nums[i];
        }
        int temp = nums[i];
        nums[i] = nums[temp];
        nums[temp] = temp;
      }
    }
    return -1;
  }
}
