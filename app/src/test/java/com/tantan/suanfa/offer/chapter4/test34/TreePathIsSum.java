package com.tantan.suanfa.offer.chapter4.test34;

import java.util.Vector;
import org.junit.Test;

/** 二叉树中和为某一值的路径 */
public class TreePathIsSum {

  @Test
  public void main() {
    Tree tree = createTree();
    printPath(tree, 22);
  }

  private void printPath(Tree tree, int target) {
    if (tree == null) {
      return;
    }
    Vector<Integer> vector = new Vector<>();
    int sum = 0;
    printPathCore(tree, target, sum, vector);
  }

  private void printPathCore(Tree tree, int target, int sum, Vector<Integer> vector) {
    sum += tree.value;
    vector.add(tree.value);

    boolean isLeaf = tree.left == null && tree.right == null;
    if (sum == target && isLeaf) {
      for (Integer integer : vector) {
        System.out.print(integer + ",");
      }
      System.out.println();
    }
    if (tree.left != null) {
      printPathCore(tree.left, target, sum, vector);
    }
    if (tree.right != null) {
      printPathCore(tree.right, target, sum, vector);
    }
    vector.remove(vector.size() - 1);
  }

  private Tree createTree() {
    Tree t = new Tree(10);
    t.left = new Tree(5, new Tree(4), new Tree(7));
    t.right = new Tree(12);
    return t;
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
