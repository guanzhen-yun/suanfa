package com.tantan.suanfa.others;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 素数之积
 */
public class SushuZhiji {

  @Test
  public void main() {
    System.out.println(getJiStr(100));
  }

  private String getJiStr(int num) {
    if (num <= 3) {
      return num + "";
    }
    List<Integer> primeList = new ArrayList<>();
    int firstPrime = getFirstPrime(num);
    while (num != 1) {
      primeList.add(firstPrime);
      num = num / firstPrime;
      firstPrime = getFirstPrime(num);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < primeList.size(); i++) {
      sb.append(primeList.get(i) + " ");
      if (i != primeList.size() - 1) {
        sb.append("x ");
      }
    }
    return sb.toString();
  }

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

  private int getFirstPrime(int num) {
    if (isPrime(num)) {
      return num;
    }
    for (int i = 2; i <= num / 2; i++) {
      if (isPrime(i) && num % i == 0) {
        return i;
      }
    }
    return 0;
  }
}
