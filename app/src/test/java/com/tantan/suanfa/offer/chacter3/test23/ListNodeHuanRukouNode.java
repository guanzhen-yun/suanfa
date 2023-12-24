package com.tantan.suanfa.offer.chacter3.test23;

import org.junit.Test;

/** 链表中环的入口节点 */
public class ListNodeHuanRukouNode {

  @Test
  public void main() {
    ListNode listNode = createNode();
    ListNode inNode = getInNode(listNode);

    if (inNode != null) {
      System.out.println(inNode.value);
    }
  }

  private ListNode getInNode(ListNode listNode) {
    ListNode meetNode = meetingNode(listNode);
    if (meetNode == null) {
      return null;
    }
    ListNode tNode = meetNode.next;
    int length = 1;
    while (tNode != meetNode) {
      length++;
      tNode = tNode.next;
    }

    ListNode node1 = listNode;
    ListNode node2 = listNode;
    int index = length;
    while (index > 0) {
      node1 = node1.next;
      index--;
    }
    while (node1 != node2) {
      node1 = node1.next;
      node2 = node2.next;
    }
    return node1;
  }

  private ListNode meetingNode(ListNode listNode) {
    ListNode node1 = listNode;
    ListNode node2 = listNode;
    while (node1 != null && node1.next != null && node2 != null) {
      node1 = node1.next;
      node1 = node1.next;
      node2 = node2.next;
      if (node1 == node2) {
        return node1;
      }
    }
    return null;
  }

  // 1 2 3 4 5 6 7
  private ListNode createNode() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node4;
    return node1;
  }

  class ListNode {
    public ListNode next;
    public int value;

    public ListNode(int value) {
      this.value = value;
    }
  }
}
