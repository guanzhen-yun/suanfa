package com.tantan.suanfa.offer.chacter2.test6;

import java.util.Stack;
import org.junit.Test;

/**
 * 从尾到头打印链表 用栈实现  先进后出
 */
public class PrintNodeFromTailToTop {

  @Test
  public void main() {

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    printNode(n1);
//    printNode1(n1);
  }

  private void printNode(ListNode node) {
    Stack<ListNode> stack = new Stack<>();
    ListNode listNode = node;
    while (listNode != null) {
      stack.push(listNode);
      listNode = listNode.next;
    }

    while (stack.size() > 0) {
      ListNode n = stack.pop();
      System.out.print(n.value + " ");
    }
  }

  private void printNode1(ListNode node) {
    if (node.next != null) {
      printNode1(node.next);
      System.out.print(node.value + " ");
    }
  }

  class ListNode {

    public ListNode next;
    public int value;

    public ListNode(int value) {
      this.value = value;
    }
  }

}
