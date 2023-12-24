package com.tantan.suanfa.others.tree;

import java.util.LinkedList;
import java.util.Stack;
import org.junit.Test;

/** 二叉树遍历 ***********9 ******5***********16 ****3*****6***14*****19 **1*********************21 */
public class TreeBianli {

  class Tree {

    public Tree left;
    public Tree right;
    public int value;

    public Tree(int value, Tree left, Tree right) {
      this.left = left;
      this.right = right;
      this.value = value;
    }
  }

  @Test
  public void main() {
    Tree t1 = new Tree(1, null, null);
    Tree t2 = new Tree(21, null, null);
    Tree t3 = new Tree(3, t1, null);
    Tree t4 = new Tree(6, null, null);
    Tree t5 = new Tree(5, t3, t4);
    Tree t6 = new Tree(14, null, null);
    Tree t7 = new Tree(19, null, t2);
    Tree t8 = new Tree(16, t6, t7);
    Tree tree = new Tree(9, t5, t8);

    //    preOrder(tree);
    // midOrder(tree);
    //    postOrder(tree);
    preOrder2(tree);
    //    midOrder2(tree);
    //    postOrder2(tree);
    //    levelOrder(tree);
    //    System.out.println(getTreeHeight(tree));
  }

  // 前序遍历
  private void preOrder(Tree tree) {
    if (tree != null) {
      System.out.print(tree.value + " ");
      preOrder(tree.left);
      preOrder(tree.right);
    }
  }

  // 中序遍历
  private void midOrder(Tree tree) {
    if (tree != null) {
      midOrder(tree.left);
      System.out.print(tree.value + " ");
      midOrder(tree.right);
    }
  }

  // 后序遍历
  private void postOrder(Tree tree) {
    if (tree != null) {
      postOrder(tree.left);
      postOrder(tree.right);
      System.out.print(tree.value + " ");
    }
  }

  // 前序遍历非递归
  private void preOrder2(Tree tree) {
    Stack<Tree> stack = new Stack<>();
    Tree t = tree;
    while (!stack.isEmpty() || t != null) {
      while (t != null) {
        System.out.print(t.value + " ");
        stack.push(t);
        t = t.left;
      }
      if (!stack.isEmpty()) {
        t = stack.pop();
        t = t.right;
      }
    }
  }

  // 中序遍历非递归
  private void midOrder2(Tree tree) {
    Tree t = tree;
    Stack<Tree> stack = new Stack<>();
    while (!stack.isEmpty() || t != null) {
      while (t != null) {
        stack.push(t);
        t = t.left;
      }
      if (!stack.isEmpty()) {
        t = stack.pop();
        System.out.print(t.value + " ");
        t = t.right;
      }
    }
  }

  // 后序遍历非递归
  private void postOrder2(Tree tree) {
    Tree t = tree;
    Stack<Tree> stack = new Stack<>();
    Tree flagTree = null;
    while (t != null || !stack.isEmpty()) {
      while (t != null) {
        stack.push(t);
        t = t.left;
      }
      if (!stack.isEmpty()) {
        t = stack.pop();
        if (t.right == null || t.right == flagTree) {
          System.out.print(t.value + " ");
          flagTree = t;
          t = null;
        } else {
          stack.push(t);
          t = t.right;
        }
      }
    }
  }

  /** 层序遍历 */
  private void levelOrder(Tree tree) {
    Tree t = tree;
    LinkedList<Tree> list = new LinkedList<>();
    list.add(t);
    while (!list.isEmpty()) {
      t = list.pop();
      System.out.print(t.value + " ");
      if (t.left != null) {
        list.add(t.left);
      }
      if (t.right != null) {
        list.add(t.right);
      }
    }
  }

  /** 获取树的高度 */
  private int getTreeHeight(Tree tree) {
    if (tree == null) {
      return 0;
    }
    if (tree.left == null && tree.right == null) {
      return 1;
    } else {
      return 1 + Math.max(getTreeHeight(tree.left), getTreeHeight(tree.right));
    }
  }
}
