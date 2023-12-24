package com.tantan.suanfa.offer.chacter3.test17;

import org.junit.Test;

public class PrintMaxNums2 {

  @Test
  public void main() {
    int n = 3;
    printNum(n);
  }

  private void printNum(int n) {
    if (n <= 0) {
      return;
    }
    char[] number = new char[n];
    for (int i = 0; i < number.length; i++) {
      number[i] = '0';
    }
    for (int i = 0; i < 10; i++) {
      number[0] = (char) (i + '0'); // 个位
      printNumCore(number, 0);
    }
  }

  private void printNumCore(char[] number, int index) {
    if (index == number.length - 1) {
      printNum(number);
      return;
    }
    for (int i = 0; i < 10; i++) {
      number[index + 1] = (char) (i + '0'); // 十位 百位..
      printNumCore(number, index + 1);
    }
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
