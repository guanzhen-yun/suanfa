package com.tantan.suanfa.others.sort;

import org.junit.Test;

/**
 * java 冒泡排序
 */
public class BubbleSort {

  @Test
  public void main() {
    int[] array = {2, 3, 1, 4, 7, 5, 6, 9, 8, 10};
    bubbleSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  private void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }


}
