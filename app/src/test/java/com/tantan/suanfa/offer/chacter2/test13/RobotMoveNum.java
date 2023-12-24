package com.tantan.suanfa.offer.chacter2.test13;

import org.junit.Test;

/** 机器人的运动范围 */
public class RobotMoveNum {

  @Test
  public void main() {
    int count = getMoveCount(4, 10, 10);
    System.out.println(count);
  }

  private int getMoveCount(int target, int row, int column) {
    boolean[][] flags = new boolean[row][column];
    return getMoveCountCore(target, row, column, 0, 0, flags);
  }

  private int getMoveCountCore(
      int target, int row, int column, int rowIndex, int columnIndex, boolean[][] flags) {
    int count = 0;
    if (rowIndex >= 0
        && rowIndex < row
        && columnIndex >= 0
        && columnIndex < column
        && !flags[rowIndex][columnIndex]
        && target >= getSumNum(rowIndex) + getSumNum(columnIndex)) {
      flags[rowIndex][columnIndex] = true;
      count =
          1
              + getMoveCountCore(target, row, column, rowIndex - 1, columnIndex, flags)
              + getMoveCountCore(target, row, column, rowIndex + 1, columnIndex, flags)
              + getMoveCountCore(target, row, column, rowIndex, columnIndex - 1, flags)
              + getMoveCountCore(target, row, column, rowIndex, columnIndex + 1, flags);
    }
    return count;
  }

  private int getSumNum(int num) {
    int sum = 0;
    int i = num;
    while (i > 0) {
      sum += i % 10;
      i = i / 10;
    }
    return sum;
  }
}
