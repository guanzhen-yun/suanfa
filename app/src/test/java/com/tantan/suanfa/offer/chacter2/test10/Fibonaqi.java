package com.tantan.suanfa.offer.chacter2.test10;

import org.junit.Test;

/** 斐波那契数列 */
public class Fibonaqi {

  @Test
  public void main() {
    System.out.println(getResult(11));
  }

  // 1 1 2 3 5 8 13 21 34 55 89

  private int getResult(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    int first = 1;
    int second = 1;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = first + second;
      first = second;
      second = result;
    }
    return result;
  }
}
