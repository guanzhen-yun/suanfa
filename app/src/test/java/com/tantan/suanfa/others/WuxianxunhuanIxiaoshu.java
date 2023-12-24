package com.tantan.suanfa.others;

import org.junit.Test;

/** 无限循环小数 */
public class WuxianxunhuanIxiaoshu {

  @Test
  public void main() {
    boolean isFinite = isFiniteDecimals(5, 30);
    System.out.println(isFinite);
  }

  // m分子  n分母
  private boolean isFiniteDecimals(int m, int n) {
    // 处理假分数
    while (m > n) {
      m -= n;
    }
    // 化为最简分数
    n /= maxCommonFator(m, n);
    // 判断是否为2或5的幂
    if (isPowerOfN(n, 2) || isPowerOfN(n, 5)) {
      return true;
    } else {
      // 判断是否只有2和5两个因数
      while ((n & 0x01) == 0) {
        n >>= 1;
      }
      return isPowerOfN(n, 5);
    }
  }

  // 判断是否为n的幂
  private boolean isPowerOfN(int number, int n) {
    if (number < 2) {
      return number == 1;
    }
    switch (n) {
      case 0:
        return number == 0;
      case 1:
        return number != 0;
      case 2:
        while ((number & 0x01) == 0 && number > 2) {
          number >>= 1;
        }
        return number == 2;
      default:
        while (number % n == 0 && number > n) {
          number /= n;
        }
        return number == n;
    }
  }

  // 最大公约数
  private int maxCommonFator(int m, int n) {
    int min = m > n ? n : m;
    int max = m > n ? m : n;
    if (max % min == 0 || min == 1) {
      return min;
    }
    for (int i = min / 2; i > 0; i--) {
      if (m % i == 0 && n % i == 0) {
        return i;
      }
    }
    return 1;
  }
}
