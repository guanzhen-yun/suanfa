package com.tantan.suanfa.offer.chapter5.test49;

import org.junit.Test;

/** 丑数 */
// 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24
public class Choushu {

  @Test
  public void main() {
    int n = 1500;
    int num = getChoushu2(n);
    System.out.println(num);
  }

  private int getChoushu2(int n) {
    int[] nums = new int[n];
    nums[0] = 1;
    int nextIndex = 1;
    int num2 = 0;
    int num3 = 0;
    int num5 = 0;

    while (nextIndex < n) {
      int min = min(nums[num2] * 2, nums[num3] * 3, nums[num5] * 5);
      nums[nextIndex] = min;
      while (nums[num2] * 2 <= nums[nextIndex]) {
        num2++;
      }
      while (nums[num3] * 3 <= nums[nextIndex]) {
        num3++;
      }
      while (nums[num5] * 5 <= nums[nextIndex]) {
        num5++;
      }
      nextIndex++;
    }
    int num = nums[nextIndex - 1];
    return num;
  }

  private int min(int i, int j, int k) {
    int min = Math.min(i, j);
    min = Math.min(min, k);
    return min;
  }

  private int getChoushu(int index) {
    int uglyFound = 0;
    int number = 0;
    while (uglyFound < index) {
      ++number;
      if (isChoushu(number)) {
        ++uglyFound;
      }
    }
    return number;
  }

  private boolean isChoushu(int num) {
    while (num % 2 == 0) {
      num /= 2;
    }
    while (num % 3 == 0) {
      num /= 3;
    }
    while (num % 5 == 0) {
      num /= 5;
    }
    return num == 1;
  }
}
