package com.tantan.suanfa.offer.chapter6.test53;

import org.junit.Test;

/** 0~n-1中缺失的数字 */
public class FindUnExistNum {

  @Test
  public void main() {
    int[] nums = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
    int unExsistNum = findUnExsistNum(nums, 0, nums.length - 1);
    System.out.println(unExsistNum);
  }

  private int findUnExsistNum(int[] nums, int start, int end) {
    while (start <= end) {
      int middle = (start + end) / 2;
      if (nums[middle] != middle) {
        if (middle == 0 || nums[middle - 1] == middle - 1) {
          return middle;
        }
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }
    if (start == nums.length) {
      return nums.length;
    }
    return -1;
  }
}
