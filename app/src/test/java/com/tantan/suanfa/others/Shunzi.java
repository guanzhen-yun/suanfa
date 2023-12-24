package com.tantan.suanfa.others;

import org.junit.Test;

/**
 * 扑克牌顺子 排序 数组
 */
public class Shunzi {

  @Test
  public void main() {
    int[] nums = new int[]{0, 0, 1, 2, 5};
    System.out.println(isShunZi(nums));
  }

  private boolean isShunZi(int[] nums) {
    sort(nums);

    int zeroNums = 0;
    int firstNum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroNums++;
      } else if (firstNum == 0) {
        firstNum = nums[i];
      } else {
        if (nums[i] - firstNum != 1 && zeroNums != 0) {
          if (nums[i] - firstNum >= (zeroNums - 1)) {
            zeroNums = zeroNums - (nums[i] - firstNum - 1);
            firstNum = nums[i];
          } else {
            return false;
          }
        } else if (nums[i] - firstNum != 1) {
          return false;
        } else {
          firstNum++;
        }
      }
    }
    if (zeroNums != 0) {
      return false;
    } else {
      return true;
    }
  }

  private void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }

}
