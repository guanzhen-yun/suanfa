package com.tantan.suanfa.offer.chapter4.test28;

import org.junit.Test;

/** 对称的二叉树 */
public class DuichenTree {

  @Test
  public void main() {
    Tree t = createTree();
    System.out.println(isDuichenTree(t));
    Tree t1 = createTree1();
    System.out.println(isDuichenTree(t1));
    Tree t2 = createTree2();
    System.out.println(isDuichenTree(t2));
  }

  private boolean isDuichenTree(Tree tree) {
    return isDuichenTreeCore(tree, tree);
  }

  private boolean isDuichenTreeCore(Tree tree1, Tree tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    if (tree1.value != tree2.value) {
      return false;
    }
    return isDuichenTreeCore(tree1.left, tree2.right) && isDuichenTreeCore(tree1.right, tree2.left);
  }

  private Tree createTree() {
    Tree root = new Tree(8);
    root.left = new Tree(6, new Tree(5), new Tree(7));
    root.right = new Tree(6, new Tree(7), new Tree(5));
    return root;
  }

  private Tree createTree1() {
    Tree root = new Tree(8);
    root.left = new Tree(6, new Tree(5), new Tree(7));
    root.right = new Tree(9, new Tree(7), new Tree(5));
    return root;
  }

  private Tree createTree2() {
    Tree root = new Tree(7);
    root.left = new Tree(7, new Tree(7), new Tree(7));
    root.right = new Tree(7, new Tree(7), null);
    return root;
  }

  class Tree {
    public Tree left;
    public Tree right;
    public int value;

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
