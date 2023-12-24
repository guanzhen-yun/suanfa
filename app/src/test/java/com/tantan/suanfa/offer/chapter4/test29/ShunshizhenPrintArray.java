package com.tantan.suanfa.offer.chapter4.test29;

import org.junit.Test;

/** 顺时针打印矩阵 */
public class ShunshizhenPrintArray {

  @Test
  public void main() {

    int[][] arrays = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    printArray(arrays);
  }

  private void printArray(int[][] arrays) {
    if (arrays == null || arrays.length == 0) {
      return;
    }
    int rows = arrays.length;
    int columns = arrays[0].length;
    int start = 0;
    while (columns > start * 2 && rows > start * 2) {
      printArrayCore(arrays, start);
      start++;
    }
  }

  private void printArrayCore(int[][] arrays, int start) {
    int rows = arrays.length;
    int columns = arrays[0].length;
    int endX = columns - 1 - start;
    int endY = rows - 1 - start;
    // 从左到右
    for (int i = start; i <= endX; i++) {
      int number = arrays[start][i];
      System.out.print(number + ",");
    }
    // 从上到下
    if (start < endY) {
      for (int i = start + 1; i <= endY; i++) {
        int number = arrays[i][endX];
        System.out.print(number + ",");
      }
    }
    // 从右到左
    if (start < endX && start < endY) {
      for (int i = endX - 1; i >= start; i--) {
        int number = arrays[endY][i];
        System.out.print(number + ",");
      }
    }

    // 从下到上
    if (start < endX && start < endY - 1) {
      for (int i = endY - 1; i >= start + 1; i--) {
        int number = arrays[i][start];
        System.out.print(number + ",");
      }
    }
  }
}
