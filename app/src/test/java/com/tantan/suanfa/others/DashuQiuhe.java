package com.tantan.suanfa.others;

import org.junit.Test;

/** 大数求和 */
public class DashuQiuhe {
  @Test
  public void main() {
    String str1 = "123";
    String str2 = "99946";

    String str = getResult(str1, str2);
    System.out.println(str);
  }

  private String getResult(String str1, String str2) {
    boolean isOver = false;
    int takeOver = 0;
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    int len1 = chars1.length;
    int len2 = chars2.length;
    char[] temp = null;
    if (len1 > len2) {
      temp = chars1;
      chars1 = chars2;
      chars2 = temp;
    }

    int len = chars1.length;
    int extraLen = chars2.length - chars1.length;
    char[] chars = new char[len];
    for (int i = len - 1; i >= 0; i--) {
      int num1 = chars1[i] - '0';
      int num2 = chars2[i + extraLen] - '0';
      int num = num1 + num2 + takeOver;
      if (num >= 10) {
        num -= 10;
        takeOver = 1;
        if (i == 0 && extraLen == 0) {
          isOver = true;
        }
      } else {
        takeOver = 0;
      }
      chars[i] = (char) (num + '0');
    }
    if (isOver) {
      char[] newChars = new char[chars.length + 1];
      for (int i = 0; i < newChars.length; i++) {
        if (i == 0) {
          newChars[i] = '1';
        } else {
          newChars[i] = chars[i - 1];
        }
      }
      return String.valueOf(newChars);
    } else {
      if (extraLen == 0) {
        return String.valueOf(chars);
      } else {
        char[] newChars = new char[chars2.length];
        for (int i = newChars.length - 1; i >= 0; i--) {
          if (i >= newChars.length - chars1.length) {
            newChars[i] = chars[i - extraLen];
          } else {
            int numMax = chars2[i] - '0';
            int num = numMax + takeOver;
            if (num >= 10) {
              num -= 10;
              takeOver = 1;
              if (i == 0) {
                isOver = true;
              }
            } else {
              takeOver = 0;
            }
            newChars[i] = (char) (num + '0');
          }
        }
        if (isOver) {
          char[] newChars1 = new char[newChars.length + 1];
          for (int i = 0; i < newChars1.length; i++) {
            if (i == 0) {
              newChars1[i] = '1';
            } else {
              newChars1[i] = newChars[i - 1];
            }
          }
          return String.valueOf(newChars1);
        } else {
          return String.valueOf(newChars);
        }
      }
    }
  }
}
