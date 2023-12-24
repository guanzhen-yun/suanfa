package com.tantan.suanfa.offer.chapter4.test32;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/** 从上到下打印二叉树 */
public class PrintTreeFromUpToDown {

  @Test
  public void main() {
    Tree t = createTree();
    printTreeFromUpToDown(t);
  }

  private void printTreeFromUpToDown(Tree t) {
    Queue<Tree> queue = new LinkedList<>();
    queue.add(t);
    while (!queue.isEmpty()) {
      Tree tree = queue.poll();
      System.out.print(tree.value + " ");
      if (tree.left != null) {
        queue.add(tree.left);
      }
      if (tree.right != null) {
        queue.add(tree.right);
      }
    }
  }

  private Tree createTree() {
    Tree root = new Tree(8);
    root.left = new Tree(6, new Tree(5), new Tree(7));
    root.right = new Tree(10, new Tree(9), new Tree(11));
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
