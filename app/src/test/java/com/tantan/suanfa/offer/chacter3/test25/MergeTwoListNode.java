package com.tantan.suanfa.offer.chacter3.test25;

import org.junit.Test;

/** 合并两个排序的链表 */
public class MergeTwoListNode {

  @Test
  public void main() {
    int[] nums1 = {1, 3, 5, 7, 9};
    int[] nums2 = {2, 4, 6, 8, 10, 12, 14};
    ListNode listNode1 = createListNode(nums1, 0);
    ListNode listNode2 = createListNode(nums2, 0);
    ListNode mergeNode = mergeListNodes(listNode1, listNode2);
    System.out.println(mergeNode.value);
  }

  private ListNode mergeListNodes(ListNode node1, ListNode node2) {
    if (node1 == null && node2 == null) {
      return null;
    }
    if (node1 == null) {
      return node2;
    }
    if (node2 == null) {
      return node1;
    }
    ListNode node = null;
    if (node1.value < node2.value) {
      node = node1;
      node.next = mergeListNodes(node1.next, node2);
    } else {
      node = node2;
      node.next = mergeListNodes(node1, node2.next);
    }
    return node;
  }

  private ListNode createListNode(int[] nums, int index) {
    ListNode listNode = new ListNode(nums[index]);
    if (index == nums.length - 1) {
      return new ListNode(nums[index]);
    } else {
      listNode.next = createListNode(nums, index + 1);
    }
    return listNode;
  }

  class ListNode {
    public ListNode next;
    public int value;

    public ListNode(int value) {
      this.value = value;
    }

    public ListNode() {}
  }
}
