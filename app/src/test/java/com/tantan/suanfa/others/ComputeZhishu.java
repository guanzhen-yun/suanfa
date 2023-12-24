package com.tantan.suanfa.others;

import org.junit.Test;

/**
 * 计算质数 返回小于n的质数数量
 */
public class ComputeZhishu {

  @Test
  public void main() {
    System.out.println(countPrime(20));
  }

  private int countPrime(int n) {
    if (n <= 2) {
      return 0;
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }
    return count;
  }

  //判断是否是质数
  private boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    if (num == 2 || num == 3) {
      return true;
    }
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}
