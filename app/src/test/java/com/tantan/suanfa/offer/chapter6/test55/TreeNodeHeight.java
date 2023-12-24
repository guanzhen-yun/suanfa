package com.tantan.suanfa.offer.chapter6.test55;

import org.junit.Test;

/** 二叉树的深度 */
public class TreeNodeHeight {

  @Test
  public void main() {
    TreeNode treeNode = createNode();
    int height = getTreeNodeHeight(treeNode);
    System.out.println(height);
  }

  private int getTreeNodeHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    return 1 + Math.max(getTreeNodeHeight(treeNode.left), getTreeNodeHeight(treeNode.right));
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
