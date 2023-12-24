package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 整数拆分
 */
public class ZhengshuChaifen {

  @Test
  public void main() {
    System.out.println(getMaxResult(12));
  }

  private int getMaxResult(int num) {
    int half = num / 2;

    int max = 0;
    int result = 0;
    int mulResult = 1;
    for (int i = 1; i <= half; i++) {
      mulResult = 1;
      result = num;
      while (result >= 2 * i) {
        result = result - i;
        mulResult = mulResult * i;
      }
      mulResult = mulResult * result;
      max = Math.max(max, mulResult);
    }
    return max;
  }

}
