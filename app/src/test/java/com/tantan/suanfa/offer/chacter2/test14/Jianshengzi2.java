package com.tantan.suanfa.offer.chacter2.test14;

import org.junit.Test;

/** 剪绳子--贪婪算法 */
public class Jianshengzi2 {

  @Test
  public void main() {
    int result = getMaxMultply(10);
    System.out.println(result);
  }

  private int getMaxMultply(int n) {
    if (n <= 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    int timeOf3 = n / 3;
    if (n - timeOf3 * 3 == 1) {
      timeOf3--;
    }
    int timeOf2 = (n - timeOf3 * 3) / 2;
    return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
  }
}
