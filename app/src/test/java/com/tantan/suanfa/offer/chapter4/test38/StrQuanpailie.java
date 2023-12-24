package com.tantan.suanfa.offer.chapter4.test38;

import org.junit.Test;

/** 字符串的排列 */
public class StrQuanpailie {

  @Test
  public void main() {

    String str = "abc";
    char[] chars = str.toCharArray();
    pailie(chars);
  }

  private void pailie(char[] chars) {
    if (chars == null || chars.length == 0) {
      return;
    }
    pailieCore(chars, 0);
  }

  private void pailieCore(char[] chars, int charsBegin) {

    if (charsBegin == chars.length) {
      System.out.println(String.valueOf(chars));
    } else {
      for (int i = charsBegin; i < chars.length; i++) {
        char tmp = chars[i];
        chars[i] = chars[charsBegin];
        chars[charsBegin] = tmp;

        pailieCore(chars, charsBegin + 1); // 后面字符全排列

        tmp = chars[i]; // 每次更换完再换回去
        chars[i] = chars[charsBegin];
        chars[charsBegin] = tmp;
      }
    }
  }
}
