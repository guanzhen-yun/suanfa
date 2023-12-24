package com.tantan.suanfa.offer.chapter4.test32;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/** 分行从上到下打印二叉树 */
public class PrintTreeByLines {

  @Test
  public void main() {
    Tree t = createTree();
    printByLines(t);
  }

  private void printByLines(Tree t) {
    Queue<Tree> queue = new LinkedList<>();
    int toPrintNum = 1;
    int nextPrint = 0;
    queue.add(t);
    while (!queue.isEmpty()) {
      Tree tree = queue.poll();
      if (tree.left != null) {
        queue.add(tree.left);
        nextPrint++;
      }
      if (tree.right != null) {
        queue.add(tree.right);
        nextPrint++;
      }
      System.out.print(tree.value + " ");
      toPrintNum--;
      if (toPrintNum == 0) {
        System.out.println();
        toPrintNum = nextPrint;
        nextPrint = 0;
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
