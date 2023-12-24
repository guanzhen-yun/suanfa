package com.tantan.suanfa.offer.chapter5.test45;

import org.junit.Test;

/** 把数组排成最小的数 */
public class ArraySortMinNum {

  @Test
  public void main() {
    int[] nums = {3, 32, 321};
    String str = getMinNum(nums);
    System.out.println(str);
  }

  private String getMinNum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    if (nums.length == 1) {
      return String.valueOf(nums[0]);
    }
    int len = 1;
    String[] strings = {String.valueOf(nums[0])};
    while (len < nums.length) {
      strings = getSortStrings(strings, String.valueOf(nums[len]));
      len++;
    }
    return getStr(strings);
  }

  private String[] getSortStrings(String[] strings, String firstStr) {
    int index = 0;
    String[] sortStrings = null;
    String strMin = null;
    while (index <= strings.length) {
      String[] strArrays = new String[strings.length + 1];
      for (int i = 0; i < strArrays.length; i++) {
        if (i < index) {
          strArrays[i] = strings[i];
        } else if (i == index) {
          strArrays[index] = firstStr;
        } else {
          strArrays[i] = strings[i - 1];
        }
      }
      String str = getStr(strArrays);
      if (strMin == null) {
        strMin = str;
        sortStrings = strArrays;
      } else if (!compareStr(str, strMin)) {
        strMin = str;
        sortStrings = strArrays;
      }
      index++;
    }
    return sortStrings;
  }

  private String getStr(String[] strings) {
    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      sb.append(string);
    }
    return sb.toString();
  }

  private boolean compareStr(String str1, String str2) {
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) > str2.charAt(i)) {
        return true;
      } else if (str1.charAt(i) < str2.charAt(i)) {
        return false;
      }
    }
    return false;
  }
}
