package com.tantan.suanfa.offer.chapter6.test55;

import org.junit.Test;

/** 平衡二叉树(后序遍历) */
public class BalanceTree {

  @Test
  public void main() {
    TreeNode treeNode = createNode();
    int isBalance = isBalanced(treeNode);
    if (isBalance >= 0) {
      System.out.println("是平衡二叉树");
    } else {
      System.out.println("不是平衡二叉树");
    }
  }

  private int isBalanced(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = isBalanced(node.left);
    int right = isBalanced(node.right);
    if (left >= 0 && right >= 0) {
      int diff = left - right;
      if (diff <= 1 && diff >= -1) {
        return 1 + ((left > right) ? left : right);
      }
    }
    return -1;
  }

  private TreeNode createNode() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), null));
    treeNode.right = new TreeNode(3, null, new TreeNode(6));
    return treeNode;
  }

  class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value) {
      this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
