package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 数组排成最小的数
 */
public class ShuzuSortMinNum {

  @Test
  public void main() {
    int[] nums = new int[]{3, 30, 34, 5, 9};
    String minStr = getMinNumStr(nums);
    System.out.println(minStr);
  }

  private String getMinNumStr(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        String firstNum = String.valueOf(nums[i]);
        String secondNum = String.valueOf(nums[j]);

        if (nums[i] * getR(secondNum.length()) + nums[j]
            > nums[j] * getR(firstNum.length()) + nums[i]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
    return getLastResult(nums);
  }

  private String getLastResult(int[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      sb.append(array[i]);
    }
    return sb.toString();
  }

  private int getR(int count) {
    int result = 1;
    while (count != 0) {
      result = result * 10;
      count--;
    }
    return result;
  }

}
