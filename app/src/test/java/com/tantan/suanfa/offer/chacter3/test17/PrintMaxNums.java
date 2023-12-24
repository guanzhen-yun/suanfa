package com.tantan.suanfa.offer.chacter3.test17;

import org.junit.Test;

/** 打印从1到最大的n位数 */
public class PrintMaxNums {

  @Test
  public void main() {
    char[] nums = new char[3];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = '0';
    }
    while (!isIncreaseNum(nums)) {
      printNum(nums);
    }
  }

  private boolean isIncreaseNum(char[] nums) {
    boolean isTakeOver = false;
    int nTakeOver = 0;
    int length = nums.length;
    for (int i = length - 1; i >= 0; i--) {
      int nSum = nums[i] - '0' + nTakeOver;
      if (i == length - 1) { // 从个位开始加1
        nSum++;
      }
      if (nSum >= 10) {
        if (i == 0) {
          isTakeOver = true;
        } else {
          nTakeOver = 1;
          nSum -= 10;
          nums[i] = (char) (nSum + '0');
        }
      } else {
        nums[i] = (char) (nSum + '0');
        break;
      }
    }
    return isTakeOver;
  }

  private void printNum(char[] nums) {
    boolean isBeginZero = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != '0' && !isBeginZero) {
        isBeginZero = true;
      }
      if (isBeginZero) {
        System.out.print(nums[i]);
      }
    }
    System.out.print(",");
  }
}
