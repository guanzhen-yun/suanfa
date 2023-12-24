package com.tantan.suanfa.offer.chapter5.test41;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** 数据流中的中位数 */
public class StreamMiddleNum {

  private List<Integer> max = new ArrayList<>(); // 最大堆  里面的数都小于最小堆
  private List<Integer> min = new ArrayList<>(); // 最小堆

  @Test
  public void main() {
    insert(1);
    insert(4);
    insert(3);
    insert(8);
    insert(5);
    System.out.println(getMiddleNum());
  }

  private void insert(int num) {
    if (((min.size() + max.size()) & 1) == 0) { // 和为偶数
      if (max.size() > 0 && num < getMaxNum(max)) { // 小于最大堆的最大数
        max.add(num);
        num = getMaxNum(max);
        removeMaxNum(max);
      }
      min.add(num);
    } else { // 和为奇数
      if (min.size() > 0 && getMinNum(min) < num) { // 大于最小堆的最小数
        min.add(num);
        num = getMinNum(min);
        removeMinNum(min);
      }
      max.add(num);
    }
  }

  private void removeMinNum(List<Integer> list) {
    int index = 0;
    int minNum = list.get(index);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) < minNum) {
        minNum = list.get(i);
        index = i;
      }
    }
    list.remove(index);
  }

  private int getMinNum(List<Integer> list) {
    int minNum = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      minNum = Math.min(minNum, list.get(i));
    }
    return minNum;
  }

  private void removeMaxNum(List<Integer> list) {
    int index = 0;
    int maxNum = list.get(index);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) > maxNum) {
        maxNum = list.get(i);
        index = i;
      }
    }
    list.remove(index);
  }

  private int getMaxNum(List<Integer> list) {
    int maxNum = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      maxNum = Math.max(maxNum, list.get(i));
    }
    return maxNum;
  }

  private int getMiddleNum() {
    int size = min.size() + max.size();
    if (size < 0) {
      return -1;
    }
    int median = 0;
    if ((size & 1) == 1) { // 奇数
      median = getMinNum(min);
    } else {
      median = (getMaxNum(max) + getMinNum(min)) / 2;
    }
    return median;
  }
}
