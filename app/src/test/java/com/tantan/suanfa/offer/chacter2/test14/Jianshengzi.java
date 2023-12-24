package com.tantan.suanfa.offer.chacter2.test14;

import org.junit.Test;

/** 剪绳子 - 动态规划 */
public class Jianshengzi {

  @Test
  public void main() {
    int maxResult = getMaxMultiply(10);
    System.out.println(maxResult);
  }

  private int getMaxMultiply(int n) {
    if (n <= 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }

    int[] nums = new int[n + 1];
    nums[0] = 0;
    nums[1] = 1;
    nums[2] = 2;
    nums[3] = 3;

    int max = 0;
    for (int i = 4; i <= n; i++) {
      max = 0;
      for (int j = 1; j <= i / 2; j++) {
        max = Math.max(max, nums[j] * nums[i - j]);
        nums[i] = max;
      }
    }
    return max;
  }
}
