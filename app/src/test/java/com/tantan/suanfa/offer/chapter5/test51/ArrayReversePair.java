package com.tantan.suanfa.offer.chapter5.test51;

import org.junit.Test;

/** 数组中的逆序对 */
public class ArrayReversePair {

  @Test
  public void main() {
    int[] data = {7, 5, 6, 4};
    System.out.println(inversePair(data));
  }

  private int inversePair(int[] data) {
    if (data == null || data.length == 0) {
      return 0;
    }
    int[] copy = new int[data.length];
    for (int i = 0; i < copy.length; i++) {
      copy[i] = data[i];
    }
    int count = inversePairsCore(data, copy, 0, data.length - 1);
    return count;
  }

  private int inversePairsCore(int[] data, int[] copy, int start, int end) {
    if (start == end) {
      copy[start] = data[start];
      return 0;
    }

    int length = (end - start) / 2;
    int left = inversePairsCore(copy, data, start, start + length);
    int right = inversePairsCore(copy, data, start + length + 1, end);

    int i = start + length;
    int j = end;
    int indexCopy = end;
    int count = 0;
    while (i >= start && j >= start + length + 1) {
      if (data[i] > data[j]) {
        copy[indexCopy--] = data[i--];
        count += j - start - length;
      } else {
        copy[indexCopy--] = data[j--];
      }
    }
    for (; i >= start; --i) {
      copy[indexCopy--] = data[i];
    }
    for (; j >= start + length + 1; j--) {
      copy[indexCopy--] = data[j];
    }
    return left + right + count;
  }
}
