package com.tantan.suanfa.offer.chapter4.test37;

import org.junit.Test;

/** 序列化二叉树 */

//                  1
//          2               3
//       4              5      6

public class XuliehuaTree {
  private int index = -1;

  @Test
  public void main() {
    TreeNode treeNode = createTree();
    String str = xuliehua(treeNode);
    TreeNode newTree = fanxulie(str);
    System.out.println(newTree.value);
  }

  // 1,2,4,$,$,$,3,5,$,$,6,$,$
  private TreeNode fanxulie(String str) {
    String[] arrays = str.split(",");
    return fanxulieCore(arrays);
  }

  private TreeNode fanxulieCore(String[] arrays) {
    TreeNode node;
    index++;
    if (!arrays[index].equals("$")) {
      node = new TreeNode(Integer.parseInt(arrays[index]));
      node.left = fanxulieCore(arrays);
      node.right = fanxulieCore(arrays);
    } else {
      node = null;
    }
    return node;
  }

  private String xuliehua(TreeNode treeNode) {
    StringBuilder sb = new StringBuilder();
    xuliehuaCore(treeNode, sb);
    String str = sb.toString();
    return str.substring(0, str.length() - 1);
  }

  private void xuliehuaCore(TreeNode treeNode, StringBuilder sb) {
    if (treeNode != null) {
      sb.append(treeNode.value).append(",");
    } else {
      sb.append("$,");
    }
    if (treeNode != null) {
      xuliehuaCore(treeNode.left, sb);
      xuliehuaCore(treeNode.right, sb);
    }
  }

  private TreeNode createTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2, new TreeNode(4), null);
    root.right = new TreeNode(3, new TreeNode(5), new TreeNode(6));
    return root;
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
