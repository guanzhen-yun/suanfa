package com.tantan.suanfa.offer.chacter2.test4;

import org.junit.Test;

/** 二维数组查找 */
public class ErweiArraySearch {

  @Test
  public void main() {

    int[][] arrays = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
    for (int i = 0; i < arrays.length; i++) {
      for (int j = 0; j < arrays[i].length; j++) {
        System.out.print(arrays[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println(findNum(arrays, 14));
  }

  private boolean findNum(int[][] arrays, int num) {
    int i = 0;
    int j = 3;
    while (i <= 3 && j >= 0) {
      if (num == arrays[i][j]) {
        return true;
      }
      if (arrays[i][j] > num) {
        j--;
      }
      if (arrays[i][j] < num) {
        i++;
      }
    }
    return false;
  }
}
