package com.tantan.suanfa.others;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 和为s的正数序列
 */
public class SumEqualSXulie {

  @Test
  public void main() {
    int[][] nums = getXulie(15);//2 3 4   4 5
    for (int i = 0; i < nums.length; i++) {
      int[] array = nums[i];
      for (int j = 0; j < array.length; j++) {
        System.out.print(array[j] + ",");
      }
      System.out.print(" ");
    }
  }

  private int[][] getXulie(int target) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 1; i <= (target + 1) / 2; i++) {
      int sum = 0;
      for (int j = i; j <= (target + 1) / 2; j++) {
        if (sum < target) {
          sum += j;
          if (sum == target) {
            List<Integer> integerList = new ArrayList<>();
            for (int k = i; k <= j; k++) {
              integerList.add(k);
            }
            list.add(integerList);
            break;
          } else if (sum > target) {
            break;
          }
        }
      }
    }

    int[][] nums = new int[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      List<Integer> listI = list.get(i);
      int[] array = new int[listI.size()];
      for (int j = 0; j < listI.size(); j++) {
        array[j] = listI.get(j);
      }
      nums[i] = array;
    }
    return nums;
  }

}
