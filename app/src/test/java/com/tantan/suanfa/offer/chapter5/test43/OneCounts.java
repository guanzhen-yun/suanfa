package com.tantan.suanfa.offer.chapter5.test43;

import org.junit.Test;

/** 1-n 整数中1出现的次数 */
public class OneCounts {

  @Test
  public void main() {
    int n = 23456;
    System.out.println(getAllOneCounts(n));
  }

  private int getAllOneCounts(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      count += getCounts(i);
    }
    return count;
  }

  private int getCounts(int num) {
    int count = 0;
    while (num > 0) {
      int i = num % 10;
      if (i == 1) {
        count++;
      }
      num = num / 10;
    }
    return count;
  }
}
