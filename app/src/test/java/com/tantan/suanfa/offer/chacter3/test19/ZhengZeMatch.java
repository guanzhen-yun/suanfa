package com.tantan.suanfa.offer.chacter3.test19;

import org.junit.Test;

/** 正则表达式匹配 .代表任意字符 * 代表前面字符出现任意次数 */
public class ZhengZeMatch {

  @Test
  public void main() {
    char[] str = {'a', 'a', 'a'};
    char[] pattern = {'a', '.', 'a'};
    boolean isMatch = match(str, pattern);
    System.out.println(isMatch);
  }

  private boolean match(char[] str, char[] pattern) {
    if (str == null || pattern == null || str.length == 0 || pattern.length == 0) {
      return false;
    }
    return matchCore(str, pattern, 0, 0);
  }

  private boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
    if (strIndex == str.length - 1 && patternIndex == pattern.length - 1) {
      return true;
    }
    if (strIndex != str.length - 1 && patternIndex == pattern.length - 1) {
      return false;
    }
    if (pattern[patternIndex + 1] == '*') {
      if (pattern[patternIndex] == str[strIndex]
          || (pattern[patternIndex] == '.' && strIndex != str.length - 1)) {
        return matchCore(str, pattern, strIndex + 1, patternIndex + 2)
            || matchCore(str, pattern, strIndex + 1, patternIndex)
            || matchCore(str, pattern, strIndex, patternIndex + 2);
      } else {
        return matchCore(str, pattern, strIndex, patternIndex + 2);
      }
    }
    if (str[strIndex] == pattern[patternIndex]
        || (pattern[patternIndex] == '.' && strIndex != str.length - 1)) {
      return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
    }
    return false;
  }
}
