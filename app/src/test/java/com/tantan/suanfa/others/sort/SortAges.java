package com.tantan.suanfa.others.sort;

import org.junit.Test;

/** 排序公司员工年龄 */
public class SortAges {

  @Test
  public void main() {
    int[] ages = {15, 34, 23, 67, 45, 67, 45, 23, 45, 67, 56, 45, 34, 23, 34, 35, 78};
    sortAge(ages);
    for (int i = 0; i < ages.length; i++) {
      System.out.print(ages[i] + " ");
    }
  }

  private void sortAge(int[] ages) {
    if (ages == null || ages.length == 0) {
      return;
    }

    int[] arrays = new int[100];

    for (int i = 0; i < ages.length; i++) {
      if (ages[i] <= 0 || ages[i] >= 100) {
        System.out.println("年龄输入错误");
        return;
      }
      arrays[ages[i]]++;
    }

    int index = 0;
    for (int i = 0; i < arrays.length; i++) {
      for (int j = 0; j < arrays[i]; j++) {
        ages[index] = i;
        index++;
      }
    }
  }
}
