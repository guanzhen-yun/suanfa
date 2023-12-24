package com.tantan.suanfa.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 数组相对排序 一个map 配合list
 */

public class XiangduiPaixu {

  @Test
  public void main() {
    int[] array1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] array2 = new int[]{2, 1, 4, 3, 9, 6};
    int[] newSortArray = getNewArraySort(array1, array2);
    for (int i = 0; i < newSortArray.length; i++) {
      System.out.print(newSortArray[i] + " ");
    }
    System.out.println();
  }

  private int[] getNewArraySort(int[] array1, int[] array2) {
    Map<Integer, Integer> mapArray = new HashMap<>();
    List<Integer> otherList = new ArrayList<>();
    for (int i = 0; i < array2.length; i++) {
      mapArray.put(array2[i], 0);
    }

    for (int i = 0; i < array1.length; i++) {
      if (!mapArray.containsKey(array1[i])) {
        otherList.add(array1[i]);
      } else {
        int num = mapArray.get(array1[i]);
        mapArray.put(array1[i], ++num);
      }
    }

    int newArray[] = new int[array1.length];
    int index = 0;
    for (int i = 0; i < array2.length; i++) {
      int num = mapArray.get(array2[i]);
      while (num > 0) {
        newArray[index] = array2[i];
        num--;
        index++;
      }
    }
    for (int i = 0; i < otherList.size(); i++) {
      newArray[index] = otherList.get(i);
      index++;
    }
    return newArray;
  }
}
