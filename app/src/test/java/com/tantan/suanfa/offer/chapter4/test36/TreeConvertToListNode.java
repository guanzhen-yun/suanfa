package com.tantan.suanfa.offer.chapter4.test36;

import org.junit.Test;

/** 二叉搜索树与双向链表 */
public class TreeConvertToListNode {
  private Tree listNode = null; // 一直指向最后一个链表节点

  @Test
  public void main() {
    Tree tree = createTree();
    Tree newTree = convertNode(tree);
    System.out.println(newTree.value);
  }

  private Tree convertNode(Tree tree) {
    if (tree == null) {
      return null;
    }
    convertNodeCore(tree);

    Tree t = listNode;
    while (t != null && t.left != null) {
      t = t.left;
    }
    return t;
  }

  private void convertNodeCore(Tree tree) {
    if (tree == null) {
      return;
    }
    if (tree.left != null) {
      convertNodeCore(tree.left);
    }
    tree.left = listNode;
    if (listNode != null) {
      listNode.right = tree;
    }
    listNode = tree;
    if (tree.right != null) {
      convertNodeCore(tree.right);
    }
  }

  private Tree createTree() {
    Tree tree = new Tree(10);
    tree.left = new Tree(6, new Tree(4), new Tree(8));
    tree.right = new Tree(14, new Tree(12), new Tree(16));
    return tree;
  }

  class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree() {}

    public Tree(int value) {
      this.value = value;
    }

    public Tree(int value, Tree left, Tree right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
