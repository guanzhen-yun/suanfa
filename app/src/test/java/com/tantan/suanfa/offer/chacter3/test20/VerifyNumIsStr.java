package com.tantan.suanfa.offer.chacter3.test20;

import org.junit.Test;

/** 表示数值的字符串 */
public class VerifyNumIsStr {

  @Test
  public void main() {

    String str = "123.45e+6";
    char[] chars = str.toCharArray();
    boolean isNumberic = isNumberic(chars);
    if (isNumberic) {
      System.out.println("是有效数字");
    } else {
      System.out.println("不是有效数字");
    }
  }

  private boolean isNumberic(char[] chars) {
    if (chars == null || chars.length == 0) {
      return false;
    }
    int index = scanFuhaoInteger(chars, 0);
    int indexT = scanUnsignedInteger(chars, index);
    boolean numberic = false;
    if (indexT > index) {
      numberic = true;
      index = indexT;
    }
    if (index < chars.length && chars[index] == '.') { // 到小数点 看后面有没有数字
      ++index;
      int indexTemp = scanUnsignedInteger(chars, index);
      numberic = indexTemp > index || numberic; // 小数部分有数字
      index = indexTemp;
    }
    if (index < chars.length && (chars[index] == 'e' || chars[index] == 'E')) { // 指数部分
      ++index;
      if (index < chars.length) {
        int indexTemp = scanFuhaoInteger(chars, index);
        int indexTT = scanUnsignedInteger(chars, indexTemp);
        if (indexTT > indexTemp) {
          numberic = true;
          index = indexTT;
        } else {
          index = indexTemp;
        }
      } else {
        numberic = false;
      }
    }
    return numberic && index == chars.length;
  }

  private int scanFuhaoInteger(char[] chars, int index) {
    if (chars[index] == '+' || chars[index] == '-') {
      ++index;
    }
    return index;
  }

  private int scanUnsignedInteger(char[] chars, int index) {
    while (index != chars.length && chars[index] >= '0' && chars[index] <= '9') {
      ++index;
    }
    return index;
  }
}
