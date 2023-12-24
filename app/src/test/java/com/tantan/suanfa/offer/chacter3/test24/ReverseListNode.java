package com.tantan.suanfa.offer.chacter3.test24;

import org.junit.Test;

/** 反转链表 */
public class ReverseListNode {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    ListNode listNode = createListNode(nums);
    ListNode reverseNode = reverseListNode2(listNode);
    if (reverseNode != null) {
      System.out.println(reverseNode.value);
    }
  }

  // 递归
  private ListNode reverseListNode2(ListNode listNode) {
    ListNode nextNode = listNode.next;
    ListNode preListNode = listNode;
    preListNode.next = null;
    return reverseListNode2Core(preListNode, nextNode);
  }

  private ListNode reverseListNode2Core(ListNode preNode, ListNode nextNode) {
    if (nextNode.next != null) {
      ListNode nNode = nextNode.next;
      nextNode.next = preNode;
      preNode = nextNode;
      return reverseListNode2Core(preNode, nNode);
    } else {
      nextNode.next = preNode;
      return nextNode;
    }
  }

  private ListNode reverseListNode(ListNode listNode) {
    if (listNode == null) {
      return null;
    }
    ListNode node = listNode.next; // 2
    ListNode preNode = listNode; // 1
    preNode.next = null;
    while (node != null && node.next != null) {
      ListNode nextNode = node.next;
      node.next = preNode;
      preNode = node;
      node = nextNode;
    }
    if (node != null) {
      node.next = preNode;
    } else {
      return preNode;
    }
    return node;
  }

  private ListNode createListNode(int[] nums) {
    ListNode listNode = null;
    ListNode node = null;
    for (int i = 0; i < nums.length; i++) {
      if (listNode == null) {
        listNode = new ListNode(nums[i]);
        node = listNode;
      } else {
        node.next = new ListNode(nums[i]);
        node = node.next;
      }
    }
    return listNode;
  }

  class ListNode {
    public ListNode next;
    public int value;

    public ListNode() {}

    public ListNode(int value) {
      this.value = value;
    }
  }
}
