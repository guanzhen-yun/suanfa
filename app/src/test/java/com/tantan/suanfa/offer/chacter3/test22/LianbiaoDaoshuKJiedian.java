package com.tantan.suanfa.offer.chacter3.test22;

import org.junit.Test;

/** 链表中倒数第k个节点 */
public class LianbiaoDaoshuKJiedian {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    ListNode listNode = createListNode(nums);
    ListNode kNode = getLastKNode(listNode, 3);
    if (kNode != null) {
      System.out.println(kNode.value);
    }
  }

  private ListNode getLastKNode(ListNode listNode, int k) {
    if (k <= 0 || listNode == null) {
      return null;
    }
    ListNode node1 = listNode;
    ListNode node2 = listNode;

    int index = 0;

    while (node2 != null && node1 != null) {
      if (index > k - 1) {
        node1 = node1.next;
        node2 = node2.next;
      } else {
        node1 = node1.next;
        index++;
      }
    }
    if (index != k) {
      return null;
    }
    return node2;
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
