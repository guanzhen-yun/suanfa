package com.tantan.suanfa.offer.chapter4.test31;

import java.util.Stack;
import org.junit.Test;

/** 栈的压入、弹出序列 */
public class StackPopPush {

  @Test
  public void main() {
    int[] num1 = {1, 2, 3, 4, 5};
    int[] num2 = {4, 5, 3, 2, 1};
    boolean isValid = isValidXulie(num1, num2);
    System.out.println(isValid);
  }

  private boolean isValidXulie(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return false;
    }
    if (nums1.length != nums2.length) {
      return false;
    }
    boolean isValid = false;
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    int i = 0;
    while (index < nums2.length) {
      while (stack.isEmpty() || stack.peek() != nums2[index]) {
        if (i == nums1.length) {
          break;
        }
        stack.push(nums1[i]);
        i++;
      }

      if (stack.peek() != nums2[index]) {
        break;
      }
      index++;
      stack.pop();
    }

    if (stack.isEmpty() && index == nums2.length) {
      isValid = true;
    }
    return isValid;
  }
}
