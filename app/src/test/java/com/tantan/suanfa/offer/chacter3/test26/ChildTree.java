package com.tantan.suanfa.offer.chacter3.test26;

import org.junit.Test;

/** 树的子结构 */
public class ChildTree {

  @Test
  public void main() {
    TreeNode treeNode1 = new TreeNode(8);
    treeNode1.left =
        new TreeNode(8, new TreeNode(9), new TreeNode(2, new TreeNode(4), new TreeNode(7)));
    treeNode1.right = new TreeNode(7);

    TreeNode treeNode2 = new TreeNode(8);
    treeNode2.left = new TreeNode(9);
    treeNode2.right = new TreeNode(2);

    boolean isContains = isContains(treeNode1, treeNode2);
    System.out.println(isContains);
  }

  private boolean isContainsChildTree(TreeNode treeNode1, TreeNode treeNode2) {
    if (treeNode2 == null) {
      return true;
    }
    if (treeNode1 == null) {
      return false;
    }
    if (treeNode1.value != treeNode2.value) {
      return false;
    }
    return isContainsChildTree(treeNode1.left, treeNode2.left)
        && (isContainsChildTree(treeNode1.right, treeNode2.right));
  }

  private boolean isContains(TreeNode treeNode1, TreeNode treeNode2) {
    boolean isContains = false;
    if (treeNode1 != null && treeNode2 != null) {
      if (treeNode1.value == treeNode2.value) {
        isContains = isContainsChildTree(treeNode1, treeNode2);
      }
      if (!isContains) {
        isContains = isContains(treeNode1.left, treeNode2);
      }
      if (!isContains) {
        isContains = isContains(treeNode1.right, treeNode2);
      }
    }
    return isContains;
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
