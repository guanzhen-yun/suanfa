package com.tantan.suanfa.offer.chacter2.test5;

import org.junit.Test;

/**
 * 插入两个排序的数组
 */
public class InsertTwoSortArray {

  @Test
  public void main() {
    int[] array1 = {2, 5, 7, 9, 10, 15};
    int[] array2 = {1, 3, 4, 6, 8, 12, 18};
    int[] newArray = newMergeArray(array1, array2);
    for (int i = 0; i < newArray.length; i++) {
      System.out.print(newArray[i] + " ");
    }
  }

  private int[] newMergeArray(int[] array1, int[] array2) {
    int length = array1.length + array2.length;
    int[] newArray = new int[length];
    int i = array1.length - 1;
    int j = array2.length - 1;
    int newIndex = length - 1;
    while (i >= 0 && j >= 0) {
      if (array1[i] > array2[j]) {
        newArray[newIndex] = array1[i];
        i--;
      } else {
        newArray[newIndex] = array2[j];
        j--;
      }
      newIndex--;
    }
    while (i >= 0) {
      newArray[newIndex] = array1[i];
      i--;
      newIndex--;
    }

    while (j >= 0) {
      newArray[newIndex] = array2[j];
      j--;
      newIndex--;
    }
    return newArray;
  }

}
