package com.tantan.suanfa.others.sort;

import org.junit.Test;

/**
 * 冒泡排序链表
 */
public class BubbleSortLinkedList {

  @Test
  public void main() {
    Node node1 = new Node(3);
    Node node2 = new Node(6);
    Node node3 = new Node(2);
    Node node4 = new Node(1);
    Node node5 = new Node(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    bubbleSort(node1, 5);
    Node curNode = node1;
    for (int i = 0; i < 5; i++) {
      System.out.println(curNode.value);
      curNode = curNode.next;
    }
  }

  private Node bubbleSort(Node head, int length) {
    for (int i = 0; i < length; i++) {
      Node curNode = head;
      for (int j = 0; j < length - i - 1; j++) {
        if (curNode.value > curNode.next.value) {
          int temp = curNode.value;
          curNode.value = curNode.next.value;
          curNode.next.value = temp;
        }
        curNode = curNode.next;
      }
    }
    return head;
  }

  class Node {

    public int value;
    public Node next;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value + "";
    }
  }
}
