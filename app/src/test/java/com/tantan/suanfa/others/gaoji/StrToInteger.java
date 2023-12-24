package com.tantan.suanfa.others.gaoji;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 字符串转换整数
 */
public class StrToInteger {

  @Test
  public void main() {
    System.out.println(strToInteger("  21474836471"));
  }

  private int strToInteger(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }
    boolean isFushu = false;
    boolean isNum = false;
    boolean isFirstZero = false;
    List<Integer> listNum = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (c == '-') {
        if (!isFushu && !isNum) {
          isFushu = true;
        } else {
          return 0;
        }
      } else if (c == '0' && !isNum) {
        if (isFushu) {
          return 0;
        }
        isFirstZero = true;
        isNum = true;
      } else if (c >= '0' && c <= '9' && !isFirstZero) {
        isNum = true;
        listNum.add(c - '0');
      } else if (isNum && (c < '0' || c > '9')) {
        break;
      } else if (!isNum) {
        return 0;
      }
    }

    if (isFushu && listNum.size() == 0) {
      return 0;
    }
    StringBuilder sb = new StringBuilder();
    if (isFushu) {
      sb.append("-");
    }
    for (int i = 0; i < listNum.size(); i++) {
      sb.append(listNum.get(i));
    }

    if (checkOverRange(isFushu, sb.toString())) {
      if (isFushu) {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
    return Integer.parseInt(sb.toString());
  }

  private boolean checkOverRange(boolean isFushu, String str) {
    String max = String.valueOf(Integer.MAX_VALUE);
    String min = String.valueOf(Integer.MIN_VALUE);// -123 - 234
    if (!isFushu) {
      if (str.length() > max.length()) {
        return true;
      } else {
        for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          char c1 = max.charAt(i);
          if (c < c1) {
            return false;
          } else if (c > c1) {
            return true;
          }
        }
      }
    } else {
      if (str.length() > min.length()) {
        return true;
      } else {
        for (int i = 1; i < str.length(); i++) {
          char c = str.charAt(i);
          char c1 = min.charAt(i);
          if (c < c1) {
            return false;
          } else if (c > c1) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
