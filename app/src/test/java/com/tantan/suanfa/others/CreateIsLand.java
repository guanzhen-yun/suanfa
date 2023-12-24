package com.tantan.suanfa.others;

import org.junit.Test;

/** 创建岛屿 */

// 1 1 1 1 0
// 1 1 0 1 0
// 1 1 0 0 0
// 0 0 0 0 0
public class CreateIsLand {

  @Test
  public void main() {
    int[][] nums = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
    int count = getCount(nums);
    System.out.println(count);
  }

  private int getCount(int[][] nums) {
    int count = 0;
    boolean[][] flags = new boolean[nums.length][nums[0].length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++) {
        if (nums[i][j] == 1 && !flags[i][j]) {
          createIsland(nums, flags, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void createIsland(int[][] nums, boolean[][] flags, int i, int j) {
    flags[i][j] = true;
    if (i >= 1 && !flags[i - 1][j] && nums[i - 1][j] == 1) {
      createIsland(nums, flags, i - 1, j);
    }
    if (i + 1 <= nums.length - 1 && !flags[i + 1][j] && nums[i + 1][j] == 1) {
      createIsland(nums, flags, i + 1, j);
    }
    if (j >= 1 && !flags[i][j - 1] && nums[i][j - 1] == 1) {
      createIsland(nums, flags, i, j - 1);
    }
    if (j + 1 <= nums[0].length - 1 && !flags[i][j + 1] && nums[i][j + 1] == 1) {
      createIsland(nums, flags, i, j + 1);
    }
  }
}
