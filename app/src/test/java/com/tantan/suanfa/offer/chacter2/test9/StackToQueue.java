package com.tantan.suanfa.offer.chacter2.test9;

import java.util.Stack;
import org.junit.Test;

/** 两个栈生成队列 */
public class StackToQueue {
  private Stack<String> stack1 = new Stack<>();
  private Stack<String> stack2 = new Stack<>();

  @Test
  public void main() {
    addToBotom("a");
    addToBotom("b");
    addToBotom("c");
    deleteFromTop();
    deleteFromTop();
    addToBotom("d");
    deleteFromTop();
  }

  private void addToBotom(String str) {
    stack1.push(str);
  }

  private void deleteFromTop() {
    if (stack2.isEmpty()) {
      if (stack1.isEmpty()) {
        System.out.println("error");
      } else {
        while (!stack1.isEmpty()) {
          String s = stack1.pop();
          stack2.push(s);
        }
        System.out.println(stack2.pop());
      }
    } else {
      System.out.println(stack2.pop());
    }
  }
}
