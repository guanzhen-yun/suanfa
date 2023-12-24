package com.tantan.suanfa.offer.chapter5.test48;

import org.junit.Test;

/** 最长不含重复字符的子字符串 */
public class MaxLongNoDumplicateStr {

  @Test
  public void main() {
    String str = "arabcacfr";
    int maxLen = getMaxChildNoDumplicateLen(str);
    System.out.println(maxLen);
  }

  private int getMaxChildNoDumplicateLen(String str) {
    char[] chars = str.toCharArray();
    int[] positions = new int[26];
    for (int i = 0; i < positions.length; i++) {
      positions[i] = -1;
    }
    int curLen = 0;
    int maxLen = 0;
    for (int i = 0; i < chars.length; i++) {
      int preIndex = positions[chars[i] - 'a'];
      if (preIndex < 0 || i - preIndex > curLen) {
        curLen++;
      } else {
        if (maxLen < curLen) {
          maxLen = curLen;
        }
        curLen = i - preIndex;
      }
      positions[chars[i] - 'a'] = i;
    }
    if (maxLen < curLen) {
      maxLen = curLen;
    }
    return maxLen;
  }
}
