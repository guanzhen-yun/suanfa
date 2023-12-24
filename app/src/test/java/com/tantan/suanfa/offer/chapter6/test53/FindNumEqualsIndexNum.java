package com.tantan.suanfa.offer.chapter6.test53;

import org.junit.Test;

/** 数组中数值和下标相等的元素 */
public class FindNumEqualsIndexNum {

  @Test
  public void main() {
    int[] nums = {-3, -1, 1, 3, 5};
    int num = findNumEqualsIndex(nums, 0, nums.length - 1);
    System.out.println(num);
  }

  private int findNumEqualsIndex(int[] nums, int start, int end) {
    while (start <= end) {
      int middle = (start + end) / 2;
      if (middle == nums[middle]) {
        return middle;
      } else if (nums[middle] > middle) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }
}
