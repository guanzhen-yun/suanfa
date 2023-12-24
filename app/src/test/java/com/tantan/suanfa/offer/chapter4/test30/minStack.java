package com.tantan.suanfa.offer.chapter4.test30;

import java.util.Stack;
import org.junit.Test;

/** 包含min函数的栈 */
public class minStack {

  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  @Test
  public void main() {
    addNum(3);
    addNum(5);
    addNum(1);
    addNum(2);
    System.out.println(minNum());
    System.out.println(outNum());
    System.out.println(minNum());
    System.out.println(outNum());
    System.out.println(minNum());
    System.out.println(outNum());
    System.out.println(minNum());
    System.out.println(outNum());
  }

  private void addNum(int num) {
    stack.push(num);
    if (minStack.isEmpty()) {
      minStack.push(num);
    } else {
      int minNum = minStack.peek();
      if (minNum < num) {
        minStack.push(minNum);
      } else {
        minStack.push(num);
      }
    }
  }

  private int outNum() {
    int num = stack.pop();
    minStack.pop();
    return num;
  }

  private int minNum() {
    return minStack.peek();
  }
}
