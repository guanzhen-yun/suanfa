package com.tantan.suanfa.others;

import org.junit.Test;

/**
 * 括号最大嵌套深度 字符串的处理
 */
public class Kuohao {

  @Test
  public void main() {
    String str = "(1) + ((2)) + (((3)))";
    System.out.println(getKuohaoHeight(str));
  }

  private int getKuohaoHeight(String str) {
    int length = str.length();
    int maxHeight = 0;
    int currentHeight = 0;
    for (int i = 0; i < length; i++) {
      char c = str.charAt(i);
      if (c == '(') {
        currentHeight++;
      } else if (c == ')') {
        if (maxHeight < currentHeight) {
          maxHeight = currentHeight;
        }
        currentHeight--;
      }
    }
    if (currentHeight != 0) {
      return -1;
    }
    return maxHeight;
  }

}
