package com.tantan.suanfa.offer.chapter5.test42;

import org.junit.Test;

/** 连续子数组的最大和 */
public class LianxuChildArrayMaxSum {

  @Test
  public void main() {
    int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
    int maxSum = maxChildArraySum(nums);
    System.out.println(maxSum);
  }

  private int maxChildArraySum(int[] nums) {
    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum <= 0) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }
}
