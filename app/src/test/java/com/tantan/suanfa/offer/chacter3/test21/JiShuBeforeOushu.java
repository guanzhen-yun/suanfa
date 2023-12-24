package com.tantan.suanfa.offer.chacter3.test21;

import org.junit.Test;

/** 调整数组的顺序使奇数位于偶数前面 */
public class JiShuBeforeOushu {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 5, 7, 6, 8, 11, 15, 8};
    changeOrder(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  private void changeOrder(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      while (i < j && isEven(nums[i])) {
        i++;
      }
      while (i < j && !isEven(nums[j])) {
        j--;
      }
      if (i < j) {
        swap(nums, i, j);
      }
    }
  }

  private boolean isEven(int num) {
    return (num & 1) == 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
