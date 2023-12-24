package com.tantan.suanfa.offer.chapter4.test32;

import java.util.Stack;
import org.junit.Test;

/** 之字形打印二叉树 */
public class PrintTreeByZhi {

  @Test
  public void main() {
    Tree tree = createTree();
    printByZhi(tree);
  }

  private void printByZhi(Tree t) {
    if (t == null) {
      return;
    }
    int current = 0;
    Stack<Tree> stack1 = new Stack<>();
    Stack<Tree> stack2 = new Stack<>();
    stack1.push(t);
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      Tree tree = current == 0 ? stack1.pop() : stack2.pop();
      System.out.print(tree.value + " ");
      if (current == 0) {
        if (tree.left != null) {
          stack2.push(tree.left);
        }
        if (tree.right != null) {
          stack2.push(tree.right);
        }
      } else {
        if (tree.right != null) {
          stack1.push(tree.right);
        }
        if (tree.left != null) {
          stack1.push(tree.left);
        }
      }
      if ((current == 0 && stack1.isEmpty()) || current == 1 && stack2.isEmpty()) {
        System.out.println();
        current = 1 - current;
      }
    }
  }

  private Tree createTree() {
    Tree tree = new Tree(1);

    tree.left = new Tree(2, new Tree(4), new Tree(5));
    tree.left.left.left = new Tree(8);
    tree.left.left.right = new Tree(9);
    tree.left.right.left = new Tree(10);
    tree.left.right.right = new Tree(11);

    tree.right = new Tree(3, new Tree(6), new Tree(7));
    tree.right.left.left = new Tree(12);
    tree.right.left.right = new Tree(13);
    tree.right.right.left = new Tree(14);
    tree.right.right.right = new Tree(15);

    return tree;
  }

  class Tree {
    public int value;
    public Tree left;
    public Tree right;

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
