package com.tantan.suanfa.offer.chapter4.test27;

import java.util.Stack;
import org.junit.Test;

/** 二叉树镜像 */
public class TreeMirror {

  @Test
  public void main() {

    Tree tree = createTree();

    mirrorTree2(tree);
    System.out.println(tree.value);
  }

  private void mirrorTree(Tree tree) {
    if (tree == null) {
      return;
    }
    if (tree.left == null && tree.right == null) {
      return;
    }
    Tree pTmp = tree.left;
    tree.left = tree.right;
    tree.right = pTmp;
    if (tree.left != null) {
      mirrorTree(tree.left);
    }
    if (tree.right != null) {
      mirrorTree(tree.right);
    }
  }

  private void mirrorTree2(Tree tree) {
    Stack<Tree> stack = new Stack<>();
    stack.add(tree);
    while (!stack.isEmpty()) {
      Tree tt = stack.pop();
      if (tt != null) {
        Tree tmp = tt.left;
        tt.left = tt.right;
        tt.right = tmp;
        if (tt.left != null) {
          stack.push(tt.left);
        }
        if (tt.right != null) {
          stack.push(tt.right);
        }
      }
    }
  }

  private Tree createTree() {
    Tree tree = new Tree(8);
    tree.left = new Tree(6, new Tree(5), new Tree(7));
    tree.right = new Tree(10, new Tree(9), new Tree(11));
    return tree;
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
