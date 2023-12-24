package com.tantan.suanfa.offer.chapter5.test39;

import org.junit.Test;

/** 数组中出现次数超过一半的数字 */
public class GetArrayMoreHalfNum {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    int moreNum = getMoreNum2(nums);
    System.out.println(moreNum);
  }

  private int getMoreNum2(int[] nums) {
    if (!checkValid(nums)) {
      return 0;
    }
    int result = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        result = nums[i];
        count++;
      } else if (result == nums[i]) {
        count++;
      } else {
        count--;
      }
    }

    if (!checkMorethanHalf(nums, result)) {
      return 0;
    }

    return result;
  }

  private boolean checkValid(int[] nums) {
    return nums != null && nums.length != 0;
  }

  private int getMoreNum(int[] nums) {
    if (!checkValid(nums)) {
      return 0;
    }

    int length = nums.length;
    int start = 0;
    int end = length - 1;
    int middle = length >> 1;
    int index = partion(nums, start, end);
    while (index != middle) {
      if (index > middle) {
        end = index - 1;
        index = partion(nums, start, end);
      } else {
        start = index + 1;
        index = partion(nums, start, end);
      }
    }

    int result = nums[middle];
    if (!checkMorethanHalf(nums, result)) {
      return 0;
    }
    return result;
  }

  private boolean checkMorethanHalf(int[] nums, int result) {
    int times = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == result) {
        times++;
      }
    }

    if (times * 2 > nums.length) {
      return true;
    }
    return false;
  }

  private int partion(int[] nums, int start, int end) {
    int index = randomInRange(start, end);
    swap(nums, index, end);
    int small = start - 1;
    for (index = start; index < end; ++index) {
      if (nums[index] < nums[end]) {
        ++small;
        if (small != index) {
          swap(nums, index, small);
        }
      }
    }

    ++small;
    swap(nums, small, end);

    return small;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int randomInRange(int start, int end) {
    return start + (int) (Math.random() * (end - start));
  }
}
