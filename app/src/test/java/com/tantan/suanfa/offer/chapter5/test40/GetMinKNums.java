package com.tantan.suanfa.offer.chapter5.test40;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** 获取最小的k个数 */
public class GetMinKNums {

  @Test
  public void main() {
    int[] nums = {2, 4, 6, 1, 3, 8, 7, 9, 5};
    int[] kNums = minNums2(nums, 4);

    if (kNums != null) {
      for (int i = 0; i < kNums.length; i++) {
        System.out.print(kNums[i] + " ");
      }
    }
  }

  private int[] minNums2(int[] nums, int k) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (list.size() < k) {
        list.add(nums[i]);
      } else {
        int maxIndex = getMaxNumIndex(list);
        int maxNum = list.get(maxIndex);
        int num = nums[i];
        if (num < maxNum) {
          list.remove(maxIndex);
          list.add(num);
        }
      }
    }

    int[] newNums = new int[k];
    for (int i = 0; i < k; i++) {
      newNums[i] = list.get(i);
    }
    return newNums;
  }

  private int getMaxNumIndex(List<Integer> list) {
    int maxIndex = 0;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(maxIndex) < list.get(i)) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  private int[] minNums(int[] nums, int k) {
    if (k <= 0 || nums == null || nums.length == 0 || k > nums.length) {
      return null;
    }
    int start = 0;
    int end = nums.length - 1;
    int index = partion(nums, start, end);
    while (index != k - 1) {
      if (index > k - 1) {
        end = index - 1;
        index = partion(nums, start, end);
      } else {
        start = index + 1;
        index = partion(nums, start, end);
      }
    }
    int[] newNums = new int[k];
    for (int i = 0; i < k; i++) {
      newNums[i] = nums[i];
    }
    return newNums;
  }

  private int partion(int[] nums, int start, int end) {
    int small = start - 1;
    int index = randomNum(start, end);
    swap(nums, index, end);
    for (index = start; index < end; index++) {
      if (nums[index] < nums[end]) {
        ++small;
        if (small != index) {
          swap(nums, small, index);
        }
      }
    }
    ++small;
    swap(nums, small, end);
    return small;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int randomNum(int start, int end) {
    return start + (int) (Math.random() * (end - start));
  }
}
