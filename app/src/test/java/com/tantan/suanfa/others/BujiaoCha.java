package com.tantan.suanfa.others;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** 无重叠区间 */
public class BujiaoCha {

  @Test
  public void main() {
    int[][] arrays = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
    int[][] newArrays = getNewArray(arrays);
    System.out.print("{");
    for (int i = 0; i < newArrays.length; i++) {
      System.out.print("{");
      for (int j = 0; j < newArrays[i].length; j++) {
        System.out.print(newArrays[i][j]);
        if (j != newArrays[i].length - 1) {
          System.out.print(",");
        }
      }
      System.out.print("}");
      if (i != newArrays.length - 1) {
        System.out.print(",");
      }
    }
    System.out.print("}");
  }

  private int[][] getNewArray(int[][] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      for (int j = i + 1; j < arrays.length; j++) {
        if (arrays[i][1] > arrays[j][1]) {
          int[] array = arrays[i];
          arrays[i] = arrays[j];
          arrays[j] = array;
        }
      }
    }

    List<Integer> list = new ArrayList<>();
    list.add(0);
    int preIndex = 0;
    for (int i = 1; i < arrays.length; i++) {
      if (arrays[i][0] < arrays[preIndex][1]) {
        continue;
      }
      preIndex = i;
      list.add(preIndex);
    }

    int[][] newArray = new int[list.size()][2];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = arrays[list.get(i)];
    }

    return newArray;
  }
}
