package com.tantan.suanfa.offer.chapter4.test33;

import org.junit.Test;

/** 二叉搜索树的后序遍历序列 */
public class VarifyNumsIsTree {

  @Test
  public void main() {
    int[] nums = {5, 7, 6, 9, 11, 10, 8};
    int[] nums1 = {7, 4, 6, 5};
    boolean isVerifyTree = isVerifyTree(nums1, 0, nums1.length - 1);
    System.out.println(isVerifyTree);
  }

  private boolean isVerifyTree(int[] nums, int start, int end) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (start == end) {
      return true;
    }
    int root = nums[end];
    int i = start;
    while (nums[i] < root) {
      i++;
    }
    int j = i;
    while (j < end) {
      if (nums[j] < root) {
        return false;
      }
      j++;
    }
    boolean left = true;
    if (i > 0) {
      left = isVerifyTree(nums, 0, i - 1);
    }
    boolean right = true;
    if (i < end) {
      right = isVerifyTree(nums, i, j - 1);
    }
    return left && right;
  }
}
