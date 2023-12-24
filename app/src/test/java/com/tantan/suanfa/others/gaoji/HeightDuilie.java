package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 根据身高重建队列
 */
public class HeightDuilie {

  @Test
  public void main() {
    int[][] array = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1},
        {5, 2}};  //前面参数代表身高  后面参数代表前面队列中比他高或相等的人数
    int[][] newArray = newArray(array);

    for (int i = 0; i < newArray.length; i++) {
      int[] arr = newArray[i];
      System.out.print(arr[0] + "," + arr[1]);
      System.out.print("  ");
    }
  }

  private int[][] newArray(int[][] array) {
    sortArray(array);  // 7,0  7,1  6,1  5,0  5,2  4,4    //5,0  7,0  5,2  6,1  4,4  7,1
    insertArray(array);
    return array;
  }

  private void insertArray(int[][] array) {
    for (int i = 1; i < array.length; i++) {
      int insertIndex = checkNeedInsert(array, i);
      if (insertIndex != -1) {//需要插空
        insertKong(array, i, insertIndex);
      }
    }
  }

  //实际应插入的位置
  private int checkNeedInsert(int[][] array, int index) {
    int count = array[index][1];
    int preCount = 0;
    int lastIndex = -1;
    for (int i = 0; i < index; i++) {
      if (array[i][0] >= array[index][0]) {
        if (count == preCount) {
          lastIndex = i;
          break;
        }
      }
      preCount++;
    }
    return lastIndex;
  }

  private void insertKong(int[][] array, int index, int insertIndex) {//1 2 3 4 5 6
    int[] temp = array[index];
    for (int i = index; i > insertIndex; i--) {
      array[i] = array[i - 1];
    }
    array[insertIndex] = temp;
  }

  private void sortArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i][0] < array[j][0]) {
          int[] temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        } else if (array[i][0] == array[j][0] && array[i][1] > array[j][1]) {
          int[] temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

}
