package com.tantan.suanfa.offer.chacter2.test15;

import org.junit.Test;

/** 二进制中1的个数 */
public class BinaryOneNums {

  @Test
  public void main() {
    int count = getOneCount2(15);
    System.out.println(count);
  }

  private int getOneCount(int n) {
    int flag = 1;
    int count = 0;
    while (flag > 0 && flag <= n) {
      int i = flag & n;
      if (i > 0) {
        count++;
      }
      flag = flag << 1;
    }
    return count;
  }

  private int getOneCount2(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }
}
