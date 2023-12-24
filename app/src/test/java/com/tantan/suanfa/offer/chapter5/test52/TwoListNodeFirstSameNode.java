package com.tantan.suanfa.offer.chapter5.test52;

import org.junit.Test;

/** 两个链表的第一个公共节点 */
public class TwoListNodeFirstSameNode {

  @Test
  public void main() {
    int[] nums1 = {1, 2, 3, 6, 7};
    int[] nums2 = {4, 5, 6, 7};
    ListNode node1 = createListNode(nums1);
    ListNode node2 = createListNode(nums2);
    ListNode commonNode = firstCommonNode(node1, node2);
    System.out.println(commonNode.value);
  }

  private ListNode firstCommonNode(ListNode node1, ListNode node2) {
    int len1 = getNodeLength(node1);
    int len2 = getNodeLength(node2);
    ListNode longNode = null;
    ListNode shortNode = null;
    int diffLen = 0;
    if (len1 < len2) {
      diffLen = len2 - len1;
      longNode = node2;
      shortNode = node1;
    } else {
      diffLen = len1 - len2;
      longNode = node1;
      shortNode = node2;
    }
    while (diffLen > 0) {
      longNode = longNode.next;
      diffLen--;
    }
    ListNode commonNode = null;
    while (longNode != null && shortNode != null) {
      if (longNode.value == shortNode.value && commonNode == null) {
        commonNode = longNode;
      } else if (longNode.value != shortNode.value && commonNode != null) {
        break;
      }
      longNode = longNode.next;
      shortNode = shortNode.next;
    }
    if (longNode == null) {
      return commonNode;
    } else {
      return null;
    }
  }

  private int getNodeLength(ListNode listNode) {
    ListNode node = listNode;
    int len = 0;
    while (node != null) {
      node = node.next;
      len++;
    }
    return len;
  }

  class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
      this.value = value;
    }
  }

  private ListNode createListNode(int[] nums) {
    ListNode headNode = null;
    ListNode node = null;
    for (int i = 0; i < nums.length; i++) {
      if (headNode == null) {
        headNode = new ListNode(nums[i]);
        node = headNode;
      } else {
        node.next = new ListNode(nums[i]);
        node = node.next;
      }
    }
    return headNode;
  }
}
