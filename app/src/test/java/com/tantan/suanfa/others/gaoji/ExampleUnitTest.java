package com.tantan.suanfa.others.gaoji;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ExampleUnitTest {

  @Test
  public void main() {
    int[] nums = new int[]{1, 3, 2, 3, 3, 2, 4, 4, 4, 5};
    int[] newArray = newArray(nums);
    for (int i = 0; i < newArray.length; i++) {
      System.out.print(newArray[i] + " ");
    }
    System.out.println();
  }

  private int[] newArray(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (map.containsKey(num)) {
        int count = map.get(num);
        map.put(num, ++count);
      } else {
        map.put(num, 1);
      }
    }

    int[] newArray = new int[map.size()];
    int index = 0;
    for (Integer integer : map.keySet()) {
      newArray[index] = integer;
      index++;
    }

    for (int i = 0; i < newArray.length; i++) {
      for (int j = i + 1; j < newArray.length; j++) {
        if (map.get(newArray[i]) < map.get(newArray[j])) {
          int temp = newArray[i];
          newArray[i] = newArray[j];
          newArray[j] = temp;
        }
      }
    }

    return newArray;
  }

}