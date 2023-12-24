package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 四键键盘 1--> A 2 -->Ctrl A 3 -->Ctrl C 4 -->Ctrl V
 */
public class Sijianjianpan {

  @Test
  public void main() {
    System.out.println(getMaxANums(7));
  }

  private int getMaxANums(int num) {
    int[] counts = new int[num + 1];
    counts[0] = 0;
    for (int i = 1; i <= num; i++) {
      counts[i] = counts[i - 1] + 1;
      for (int j = 2; j < i; j++) {
        counts[i] = Math.max(counts[i], counts[j - 2] * (i - j + 1));
      }
    }

    return counts[num];
  }

}
