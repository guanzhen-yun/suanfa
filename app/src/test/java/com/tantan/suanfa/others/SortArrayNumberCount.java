package com.tantan.suanfa.others;

import org.junit.Test;

/**
 * 排序数组中查找出现的次数
 */
public class SortArrayNumberCount {

  @Test
  public void main() {
    int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};

    System.out.println(getCount(nums, 8));
  }

  private int getCount(int[] nums, int target) {
    if (!checkArray(nums)) {
      return -1;
    }

    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        count++;
      } else if (nums[i] > target) {
        break;
      }
    }

    return count;
  }

  private boolean checkArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int preNum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num < preNum) {
        return false;
      }
    }
    return true;
  }

}
