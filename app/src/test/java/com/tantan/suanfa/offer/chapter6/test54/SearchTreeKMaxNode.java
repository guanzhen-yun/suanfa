package com.tantan.suanfa.offer.chapter6.test54;

import org.junit.Test;

/** 二叉搜索树的第k大节点 */
public class SearchTreeKMaxNode {
  private int k;

  @Test
  public void main() {
    TreeNode treeNode = createTree();
    k = 3;
    TreeNode kMaxNode = getKMaxTreeNode(treeNode);
    System.out.println(kMaxNode.value);
  }

  private TreeNode getKMaxTreeNode(TreeNode node) {
    TreeNode treeNode = null;
    if (node.left != null) {
      treeNode = getKMaxTreeNode(node.left);
    }
    if (treeNode == null) {
      if (k == 1) {
        treeNode = node;
      }
      k--;
    }

    if (treeNode == null && node.right != null) {
      treeNode = getKMaxTreeNode(node.right);
    }
    return treeNode;
  }

  private TreeNode createTree() {
    TreeNode treeNode = new TreeNode(5);
    treeNode.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
    treeNode.right = new TreeNode(7, new TreeNode(6), new TreeNode(8));
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
