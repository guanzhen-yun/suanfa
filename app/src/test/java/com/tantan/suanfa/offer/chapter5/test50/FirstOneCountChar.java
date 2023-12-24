package com.tantan.suanfa.offer.chapter5.test50;

import org.junit.Test;

/** 第一个只出现一次的字符 */
public class FirstOneCountChar {

  @Test
  public void main() {
    String str = "abaccdeff";
    char c = getFirstChar(str);
    System.out.println(c);
  }

  private char getFirstChar(String str) {
    char[] chars = str.toCharArray();
    int[] maps = new int[256];
    for (int i = 0; i < chars.length; i++) {
      maps[chars[i]]++;
    }
    for (int i = 0; i < chars.length; i++) {
      if (maps[chars[i]] == 1) {
        return chars[i];
      }
    }
    return '0';
  }
}
