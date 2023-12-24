package com.tantan.suanfa.offer.chacter2.test5;

import org.junit.Test;

/**
 * 替换空格
 */
public class ReplaceEmpty {

  @Test
  public void main() {
    String str = "We are happy.";
    String newStr = replaceEmptyStr(str);
    System.out.println(newStr);
  }

  private String replaceEmptyStr(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == ' ') {
        count++;
      }
    }

    int newStrLength = str.length() + count * 2;
    char[] chars = new char[newStrLength];
    int i = chars.length - 1;
    int j = str.length() - 1;
    while (i >= 0 && j >= 0) {
      if (str.charAt(j) == ' ' && i >= 2) {
        chars[i] = '0';
        chars[i - 1] = '2';
        chars[i - 2] = '%';
        i = i - 3;
      } else {
        chars[i] = str.charAt(j);
        i--;
      }
      j--;
    }
    return new String(chars);
  }


}
