package com.tantan.suanfa.offer.chacter3.test16;

import org.junit.Test;

/** 数值整数次方 */
public class ShuzhiCifang {
  private boolean isValid = true;

  @Test
  public void main() {
    int base = 5;
    int n = -2;
    float result = getCifangResult(base, n);
    if (!isValid) {
      System.out.println("操作不合法");
    } else {
      System.out.println(result);
    }
  }

  private float getCifangResult(int base, int n) {
    if (n == 0 && base < 0) {
      isValid = false;
      return 0;
    }

    if (base == 0) {
      return 0;
    }

    if (n == 1) {
      return base;
    }
    float result = getN2(base, n);
    if (n < 0) {
      result = 1.0f / result;
    }
    return result;
  }

  private float getN(int base, int n) {
    float result = 1;
    for (int i = 0; i < Math.abs(n); i++) {
      result *= base;
    }
    return result;
  }

  private float getN2(int base, int n) {
    if (base == 0) {
      return 0;
    }
    int n1 = Math.abs(n);

    if (n1 == 1) {
      return base;
    }

    float result = getN2(base, n1 >> 1);
    result *= result;
    if ((n1 & 0x1) > 0) {
      result *= base;
    }
    return result;
  }
}
