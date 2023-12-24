package com.tantan.suanfa.offer.chacter3.test18;

import org.junit.Test;

/** 删除排序链表中重复节点 */
public class DeleteDumplicateListNode {

  @Test
  public void main() {
    int[] nums = {1, 1};
    ListNode listNode = createListNode(nums);
    deleteDumplicateNodes(listNode);
  }

  private ListNode deleteDumplicateNodes(ListNode listNode) {
    ListNode head = null;
    ListNode newNode = null;
    ListNode curNode = listNode;
    while (curNode != null) {
      boolean isDumplicate = false;
      if (curNode.next != null && curNode.value == curNode.next.value) {
        isDumplicate = true;
      }
      if (isDumplicate) {
        ListNode node = curNode;
        int value = curNode.value;
        while (node != null && node.value == value) {
          node = node.next;
        }
        curNode = node;
      } else {
        if (head == null) {
          head = new ListNode(curNode.value);
          newNode = head;
        } else {
          newNode.next = new ListNode(curNode.value);
          newNode = newNode.next;
        }
        curNode = curNode.next;
      }
    }
    return head;
  }

  private ListNode createListNode(int[] nums) {
    ListNode listNode = new ListNode(nums[0]);
    ListNode node = listNode;
    for (int i = 1; i < nums.length; i++) {
      node.next = new ListNode(nums[i]);
      node = node.next;
    }
    return listNode;
  }

  class ListNode {
    ListNode next;
    int value;

    public ListNode(int value) {
      this.value = value;
    }
  }
}
