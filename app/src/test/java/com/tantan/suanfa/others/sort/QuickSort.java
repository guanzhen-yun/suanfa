package com.tantan.suanfa.others.sort;

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort {

  @Test
  public void main() {
    int[] array = {6, 3, 7, 1, 9, 4, 8, 5, 2, 10};
    int low = 0;
    int high = array.length - 1;
    quickSort(array, low, high);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  private void quickSort(int[] array, int low, int high) {
    int i, j, pivot;
    if (low >= high) {
      return;
    }
    i = low;
    j = high;
    pivot = array[low];
    while (i < j) {
      while (array[j] >= pivot && i < j) {
        j--;
      }
      while (array[i] <= pivot && i < j) {
        i++;
      }
      if (i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    array[low] = array[i];
    array[i] = pivot;

    quickSort(array, low, i - 1);
    quickSort(array, i + 1, high);
  }


}
