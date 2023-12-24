package com.tantan.suanfa.offer.chapter5.test43;

import org.junit.Test;

/** 1-n 整数中1出现的次数 */
public class OneCounts2 {
  @Test
  public void main() {
    int n = 23456;
    String str = String.valueOf(n);
    char[] chars = str.toCharArray();
    int count = getOneCount(chars, 0);
    System.out.println(count);
  }

  private int getOneCount(char[] chars, int index) {
    if (index >= chars.length) {
      return 0;
    }

    int firstOneCounts = 0;
    if (chars[index] - '0' > 1) {
      int len = chars.length - index;
      firstOneCounts = (int) Math.pow(10, len - 1);
    } else {
      String str = String.valueOf(chars);
      str = str.substring(1);
      firstOneCounts = Integer.parseInt(str) + 1;
    }

    int lastOneCount1 = 0;
    int firstNum = chars[index] - '0';
    int len = chars.length - index;
    lastOneCount1 = firstNum * (int) Math.pow(10, len - 2) * (len - 1);

    int lastOneCount2 = getOneCount(chars, index + 1);
    return firstOneCounts + lastOneCount1 + lastOneCount2;
  }
}
