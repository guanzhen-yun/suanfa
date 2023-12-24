package com.tantan.suanfa.offer.chacter2.test9;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/** 两个队列转化栈 */
public class QueueToStack {

  private Queue<String> queue1 = new LinkedList<>();
  private Queue<String> queue2 = new LinkedList<>();

  @Test
  public void main() {
    addToTop("a");
    addToTop("b");
    addToTop("c");
    deleteFromBottom();
    deleteFromBottom();
    addToTop("d");
    deleteFromBottom();
  }

  private void addToTop(String str) {
    if (queue1.isEmpty() && queue2.isEmpty()) {
      queue1.add(str);
    } else if (!queue1.isEmpty()) {
      queue1.add(str);
    } else {
      queue2.add(str);
    }
  }

  private void deleteFromBottom() {
    if (queue1.isEmpty() && queue2.isEmpty()) {
      System.out.println("error");
    } else if (!queue1.isEmpty()) {
      while (!queue1.isEmpty()) {
        String str = queue1.poll();
        if (queue1.isEmpty()) {
          System.out.println(str);
        } else {
          queue2.add(str);
        }
      }
    } else {
      while (!queue2.isEmpty()) {
        String str = queue2.poll();
        if (queue2.isEmpty()) {
          System.out.println(str);
        } else {
          queue1.add(str);
        }
      }
    }
  }
}
