package com.tantan.suanfa.offer.chapter5.test46;

import org.junit.Test;

/** 把数字翻译成字符串 */
public class NumToString {

  @Test
  public void main() {
    int num = 12258;
    int count = getStrsCount(num);
    System.out.println(count);
  }

  private int getStrsCount(int num) {
    String str = String.valueOf(num);
    char[] chars = str.toCharArray();
    int i = chars.length - 1;
    int[] counts = new int[chars.length];
    while (i >= 0) {
      if (i < chars.length - 1) {
        counts[i] = counts[i + 1];
      } else {
        counts[i] = 1;
      }

      if (i < chars.length - 1) {
        if (isValid(chars[i], chars[i + 1])) {
          if (i < chars.length - 2) {
            counts[i] += counts[i + 2];
          } else {
            counts[i] += 1;
          }
        }
      }
      i--;
    }
    return counts[0];
  }

  private boolean isValid(char c1, char c2) {
    int i = c1 - '0';
    int j = c2 - '0';
    int num = i * 10 + j;
    return num >= 10 && num <= 25;
  }
}
