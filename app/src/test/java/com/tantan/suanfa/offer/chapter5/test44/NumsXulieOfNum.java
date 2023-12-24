package com.tantan.suanfa.offer.chapter5.test44;

import org.junit.Test;

/** 数字序列中某一位的数字 */
public class NumsXulieOfNum {

  @Test
  public void main() {
    int n = 1001;
    int getNOfNums = getNOfNums(n);
    System.out.println(getNOfNums);
  }

  private int getNOfNums(int n) {
    if (n < 0) {
      return -1;
    }
    int diget = 1;
    while (true) {
      int maxDigetCounts = getMaxDigetCounts(diget);
      if (n < maxDigetCounts * diget) {
        return getNumOfIndex(diget, n);
      } else {
        n -= maxDigetCounts * diget;
        diget++;
      }
    }
  }

  private int getNumOfIndex(int diget, int n) {
    int beginNum = beginNum(diget);
    int number = beginNum + n / diget;
    int indexFromRight = diget - n % diget;
    for (int i = 1; i < indexFromRight; i++) {
      number /= 10;
    }
    number = number % 10;
    return number;
  }

  private int beginNum(int diget) {
    if (diget == 1) {
      return 0;
    }
    return (int) Math.pow(10, diget - 1);
  }

  private int getMaxDigetCounts(int diget) {
    if (diget == 1) {
      return 10;
    }
    return 9 * (int) Math.pow(10, diget - 1);
  }
}
