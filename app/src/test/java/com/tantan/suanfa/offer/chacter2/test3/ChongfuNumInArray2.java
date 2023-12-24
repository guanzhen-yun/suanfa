package com.tantan.suanfa.offer.chacter2.test3;

import org.junit.Test;

/**
 * 不修改数组 找出重复的数字
 */
public class ChongfuNumInArray2 {

  @Test
  public void main() {

    int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
    System.out.println(getDumplicateNum(nums));
  }

  private int getDumplicateNum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int length = nums.length;
    int start = 1;
    int end = length - 1;
    while (end >= start) {
      int middle = (end - start) / 2 + start;
      int count = countRange(nums, start, middle);
      if (end == start) {
        if (count > 1) {
          return start;
        } else {
          return -1;
        }
      }
      if (count > (middle - start + 1)) {
        end = middle;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

  private int countRange(int[] nums, int start, int end) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= start && nums[i] <= end) {
        ++count;
      }
    }
    return count;
  }

}
