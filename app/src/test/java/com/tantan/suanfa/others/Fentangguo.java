package com.tantan.suanfa.others;

import org.junit.Test;

/**
 * 分糖果
 */
public class Fentangguo {

  @Test
  public void main() {
    System.out.println(getCount(20));
  }

  private int getCount(int num) {
    int count = 0;
    while (num != 1) {
      if (num % 2 == 0) {
        num = num / 2;
        count++;
      } else {
        num = (num + 1) / 2;
        count++;
        count++;
      }
    }
    return count;
  }

}
