package com.tantan.suanfa.offer.chacter2.test11;

import org.junit.Test;

/** 旋转数组中最小数字 */
public class XuanzhuanArrayMinNum {

  @Test
  public void main() {
    int[] nums = {3, 4, 5, 1, 2};
    System.out.println(getMinNum(nums));
  }

  private int getMinNum(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    int midNum = 0;
    while (nums[i] >= nums[j]) {
      if (j - i == 1) {
        midNum = j;
        break;
      }
      midNum = (i + j) / 2;
      if (nums[i] == nums[j] && nums[i] == nums[midNum]) {
        return getMin(nums, i, j);
      }
      if (nums[i] <= nums[midNum]) {
        i = midNum;
      } else if (nums[j] >= nums[midNum]) {
        j = midNum;
      }
    }
    return nums[midNum];
  }

  private int getMin(int[] nums, int i, int j) {
    int index = i + 1;
    int min = nums[i];
    while (index <= j && index < nums.length) {
      min = Math.min(min, nums[index]);
      index++;
    }
    return min;
  }
}
