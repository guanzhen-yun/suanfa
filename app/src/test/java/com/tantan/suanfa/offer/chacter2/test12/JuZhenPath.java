package com.tantan.suanfa.offer.chacter2.test12;

import org.junit.Test;

/** 矩阵中的路径 */
public class JuZhenPath {

  @Test
  public void main() {
    char[][] nums = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
    boolean isContains = isContainsPath(nums, new char[] {'b', 'f', 'c', 'e'});
    System.out.println(isContains);
  }

  private boolean isContainsPath(char[][] nums, char[] paths) {
    int row = nums.length; // 行
    int column = nums[0].length; // 列
    boolean[][] flags = new boolean[row][column];
    int pathIndex = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (isContains(nums, flags, pathIndex, paths, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isContains(
      char[][] nums,
      boolean[][] flags,
      int pathIndex,
      char[] paths,
      int rowIndex,
      int columnIndex) {
    if (pathIndex == paths.length) {
      return true;
    }
    boolean hasPath = false;
    if (rowIndex >= 0
        && rowIndex <= nums.length - 1
        && columnIndex >= 0
        && columnIndex <= nums[0].length - 1
        && !flags[rowIndex][columnIndex]
        && paths[pathIndex] == nums[rowIndex][columnIndex]) {
      ++pathIndex;
      flags[rowIndex][columnIndex] = true;
      hasPath =
          isContains(nums, flags, pathIndex, paths, rowIndex, columnIndex - 1)
              || isContains(nums, flags, pathIndex, paths, rowIndex - 1, columnIndex)
              || isContains(nums, flags, pathIndex, paths, rowIndex, columnIndex + 1)
              || isContains(nums, flags, pathIndex, paths, rowIndex + 1, columnIndex);

      if (!hasPath) {
        --pathIndex;
        flags[rowIndex][columnIndex] = false;
      }
    }
    return hasPath;
  }
}
