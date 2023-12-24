package com.tantan.suanfa.offer.chapter5.test50;

import org.junit.Test;

/** 字符流中第一个只出现一次的字符 */
public class FirstOneCountStream {

  private int[] chars = new int[256];
  private int index = 0;

  @Test
  public void main() {
    for (int i = 0; i < chars.length; i++) {
      chars[i] = -1;
    }
    insertChar('g');
    insertChar('o');
    System.out.println(firstApper());
    insertChar('o');
    insertChar('g');
    insertChar('l');
    insertChar('e');
    System.out.println(firstApper());
  }

  private void insertChar(char c) {
    if (chars[c] == -1) {
      chars[c] = index;
    } else if (chars[c] >= 0) {
      chars[c] = -2;
    }
    index++;
  }

  private char firstApper() {
    int minIndex = Integer.MAX_VALUE;
    char ch = '0';
    for (int i = 0; i < 256; i++) {
      if (chars[i] >= 0 && chars[i] < minIndex) {
        ch = (char) i;
        minIndex = chars[i];
      }
    }
    return ch;
  }
}
