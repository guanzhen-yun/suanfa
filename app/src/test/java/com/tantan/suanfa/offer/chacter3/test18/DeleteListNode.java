package com.tantan.suanfa.offer.chacter3.test18;

import org.junit.Test;

/** 删除链表的节点 */
public class DeleteListNode {

  @Test
  public void main() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    ListNode listNode = createListNode(nums);
    ListNode deleteNode = getDeleteNode(listNode, 1);
    ListNode newListNode = deleteNode(listNode, deleteNode);
    System.out.println(newListNode.value);
  }

  private ListNode getDeleteNode(ListNode listNode, int num) {
    ListNode node = listNode;
    while (node.value != num) {
      node = node.next;
    }
    return node;
  }

  private ListNode deleteNode(ListNode listNode, ListNode deleteNode) {
    if (listNode == null || deleteNode == null) {
      return null;
    }

    if (listNode.next == null) {
      return null;
    }

    if (deleteNode.next == null) {
      ListNode node = listNode;
      while (node.next.value != deleteNode.value) {
        node = node.next;
      }
      node.next = null;
      return listNode;
    }

    deleteNode.value = deleteNode.next.value;
    deleteNode.next = deleteNode.next.next;

    return listNode;
  }

  private ListNode createListNode(int[] nums) {
    ListNode root = new ListNode(nums[0]);
    ListNode listNode = root;
    for (int i = 1; i < nums.length; i++) {
      listNode.next = new ListNode(nums[i]);
      listNode = listNode.next;
    }
    return root;
  }

  class ListNode {
    ListNode next;
    int value;

    public ListNode(int value) {
      this.value = value;
    }
  }
}
