package com.tantan.suanfa.offer.chapter6.test53;

import org.junit.Test;

/** 在排序数组中查找数字 */
public class FindNumInSortArray {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
    int count = findNumCount(nums, 3);
    System.out.println(count);
  }

  private int findNumCount(int[] nums, int target) {
    int firstIndex = getFirstNumIndex(nums, 0, nums.length - 1, target);
    int endIndex = getEndNumIndex(nums, 0, nums.length - 1, target);
    return endIndex - firstIndex + 1;
  }

  private int getFirstNumIndex(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    int middle = (end + start) / 2;
    if (nums[middle] == target) {
      if ((middle > 0 && nums[middle - 1] != target) || middle == 0) {
        return middle;
      } else {
        end = middle - 1;
      }
    } else if (nums[middle] > target) {
      end = middle - 1;
    } else {
      start = middle + 1;
    }
    return getFirstNumIndex(nums, start, end, target);
  }

  private int getEndNumIndex(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    int middle = (end + start) / 2;
    if (nums[middle] == target) {
      if ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1) {
        return middle;
      } else {
        start = middle + 1;
      }
    } else if (nums[middle] > target) {
      end = middle - 1;
    } else {
      start = middle + 1;
    }
    return getEndNumIndex(nums, start, end, target);
  }
}
