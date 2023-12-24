package com.tantan.suanfa.test;

public class Utils {

  public static ListNode createListNode(int[] nums) {
    ListNode listNode = null;
    ListNode node = null;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (listNode == null) {
        listNode = new ListNode(num);
        node = listNode;
      } else {
        node.next = new ListNode(num);
        node = node.next;
      }
    }
    return listNode;
  }

  //                   10
  //          6                  17
  //      3      8           13      20
  //   1                   12           24

  // 前序:10 6 3 1 8 17 13 12 20 24
  // 中序:1 3 6 8 10 12 13 17 20 24
  // 后序:1 3 8 6 12 13 24 20 17 10

  public static TreeNode createNewTree() {
    TreeNode treeNode = new TreeNode(10);
    treeNode.left = new TreeNode(6, new TreeNode(3, new TreeNode(1), null), new TreeNode(8));
    treeNode.right =
        new TreeNode(
            17, new TreeNode(13, new TreeNode(12), null), new TreeNode(20, null, new TreeNode(24)));
    return treeNode;
  }

  public static void printInt(int num) {
    System.out.print(num + " ");
  }
}
