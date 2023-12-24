package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 字符串运算 add sub mul div 字符串截取
 */
public class LISPZifuYunsuan {

  boolean isError = false;

  @Test
  public void main() {
    System.out.println(getResult("(mul (add (mul 2 9) (div 9 3)) 2)"));
  }

  //(sub (mul 2 4) (div 9 3))   5

  private int getResult(String str) {
    String pre = str.substring(1, 4);
    String content = str.substring(5, str.length() - 1);
    int left = getLeftStr(content);
    int right = getRightStr(content);
    return compute(pre, left, right);
  }

  private int getLeftStr(String content) {
    if (content.charAt(0) == '(') {
      int count = 1;
      for (int i = 1; i < content.length(); i++) {
        if (content.charAt(i) == '(') {
          count++;
        } else if (content.charAt(i) == ')') {
          count--;
        }
        if (count == 0) {
          String leftStr = content.substring(0, i + 1);
          return getResult(leftStr);
        }
      }
    } else {
      for (int i = 0; i < content.length(); i++) {
        if (content.charAt(i) == ' ') {
          return Integer.parseInt(content.substring(0, i));
        }
      }
    }
    return 0;
  }

  private int getRightStr(String content) {
    if (content.charAt(content.length() - 1) == ')') {
      int count = 1;
      for (int i = content.length() - 2; i >= 0; i--) {
        if (content.charAt(i) == ')') {
          count++;
        } else if (content.charAt(i) == '(') {
          count--;
        }
        if (count == 0) {
          String rightStr = content.substring(i);
          return getResult(rightStr);
        }
      }
    } else {
      for (int i = content.length() - 1; i >= 0; i--) {
        if (content.charAt(i) == ' ') {
          return Integer.parseInt(content.substring(i + 1));
        }
      }
    }
    return 0;
  }

  private int compute(String pre, int left, int right) {

    if (pre.equals("add")) {
      return getAddResult(left, right);
    } else if (pre.equals("sub")) {
      return getSubResult(left, right);
    } else if (pre.equals("mul")) {
      return getMulResult(left, right);
    } else if (pre.equals("div")) {
      return getDivResult(left, right);
    }
    return 0;
  }

  private int getAddResult(int i, int j) {
    return i + j;
  }

  private int getSubResult(int i, int j) {
    return i - j;
  }

  private int getMulResult(int i, int j) {
    return i * j;
  }

  private int getDivResult(int i, int j) {
    if (j == 0) {
      isError = true;
      return 0;
    } else {
      return i / j;
    }
  }
}
