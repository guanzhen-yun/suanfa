package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 转骰子 初始位置 左1 右2 前3 后4 上5 下6 L左转 R右转  B后转 F前转 A逆时针 C顺时针 左转前后不变 右=下  左=上 上=右 下=左 右转前后不变  右=上 下=右 左=下
 * 上=左 后转左右不变 前=下 后=上 上=前 下=后 前转左右不变 前=上 后=下 上=后 下=前 逆时针上下不变 前=左 右=前 后=右 左=后 顺时针 上下不变 前=右 右=后 后=左
 * 左=前
 */
public class Zhuanshaizi {

  @Test
  public void main() {
    System.out.println(outStr("LR"));
  }

  private String outStr(String inputStr) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6};//初始位置
    if (inputStr == null || inputStr.equals("")) {
      return "";
    }

    if (!checkInput(inputStr)) {
      return "";
    }
    for (int i = 0; i < inputStr.length(); i++) {
      char c = inputStr.charAt(i);
      if (c == 'L') {
        left(array);
      } else if (c == 'R') {
        right(array);
      } else if (c == 'B') {
        behind(array);
      } else if (c == 'F') {
        front(array);
      } else if (c == 'A') {
        ni(array);
      } else if (c == 'C') {
        shun(array);
      }
    }
    return outStr(array);
  }

  private String outStr(int[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      sb.append(array[i]);
    }
    return sb.toString();
  }

  private boolean checkInput(String str) {
    if (str == null || str.equals("")) {
      return false;
    }
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c != 'L' && c != 'R' && c != 'B' && c != 'F' && c != 'A' && c != 'C') {
        return false;
      }
    }
    return true;
  }

  //左1 右2 前3 后4 上5 下6
  //左转前后不变 右=下  左=上 上=右 下=左   563421
  private void left(int[] array) {
    int temp = array[1];//右
    array[1] = array[5];
    array[5] = array[0];
    array[0] = array[4];
    array[4] = temp;
  }

  //左1 右2 前3 后4 上5 下6
  //右转前后不变  右=上 下=右 左=下 上=左  653412
  private void right(int[] array) {
    int temp = array[1];//右
    array[1] = array[4];
    array[4] = array[0];
    array[0] = array[5];
    array[5] = temp;
  }

  //左1 右2 前3 后4 上5 下6
  //后转左右不变 前=下 后=上 上=前 下=后  126534
  private void behind(int[] array) {
    int temp = array[2];//前
    array[2] = array[5];
    array[5] = array[3];
    array[3] = array[4];
    array[4] = temp;
  }

  //左1 右2 前3 后4 上5 下6
  //前转左右不变 前=上 后=下 上=后 下=前  125643
  private void front(int[] array) {
    int temp = array[2];//前
    array[2] = array[4];
    array[4] = array[3];
    array[3] = array[5];
    array[5] = temp;
  }

  //左1 右2 前3 后4 上5 下6
  //上下不变 前=右 右=后 后=左 左=前  342156
  private void shun(int[] array) {
    int temp = array[2];//前
    array[2] = array[1];
    array[1] = array[3];
    array[3] = array[0];
    array[0] = temp;
  }

  //左1 右2 前3 后4 上5 下6
  //上下不变 前=左 右=前 后=右 左=后 431256
  private void ni(int[] array) {
    int temp = array[2];//前
    array[2] = array[0];
    array[0] = array[3];
    array[3] = array[1];
    array[1] = temp;
  }

}
