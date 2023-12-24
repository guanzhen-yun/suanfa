package com.tantan.suanfa.others;

import org.junit.Test;

// 1   2   3   4
// 10  11  12  5
// 9   8   7   6

/** 循环打印数组 */
public class XunhuanPrintArray {
  @Test
  public void main() {
    int[][] array = getResult(3, 4); // 三行四列
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }

  private int[][] getResult(int m, int n) {
    int[][] arrays = new int[m][n];
    int top = 0;
    int left = 0;
    int right = n - 1;
    int bottom = m - 1;
    int i = 1;
    int column = 0;
    int row = 0;
    boolean isLeftRight = true;
    boolean isTopBottom = false;

    while (i <= m * n) {
      arrays[row][column] = i;
      i++;
      if (column < right && row == top) { // 从左到右
        column++;
      } else if (column == right && row == top && !isTopBottom) { // 到最右面
        top++;
        row++;
        isTopBottom = true;
        isLeftRight = false;
      } else if (column == right && row < bottom) { // 从上到下
        row++;
      } else if (row == bottom && column == right && !isLeftRight) { // 到右下
        column--;
        right--;
        isLeftRight = true;
        isTopBottom = false;
      } else if (row == bottom && column > left) { // 从右到左
        column--;
      } else if (column == left && row == bottom && !isTopBottom) { // 到左下
        bottom--;
        row--;
        isTopBottom = true;
        isLeftRight = false;
      } else if (row > top && column == left) { // 从下到上
        row--;
      } else if (row == top && column == left && !isLeftRight) { // 到左上
        column++;
        left++;
        isLeftRight = true;
        isTopBottom = false;
      }
    }

    return arrays;
  }
}
