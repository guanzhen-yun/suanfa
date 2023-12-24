package com.tantan.suanfa.offer.chacter2.test8;

import org.junit.Test;

/** 获取树 中序遍历 的下一个节点 */
//                                a
//                       b                 c
//                   d       e          f    g
//                       h      i
public class GetNextNode {

  @Test
  public void main() {
    Tree root = new Tree("a");
    Tree t1 = new Tree("b");
    Tree t2 = new Tree("c");
    Tree t3 = new Tree("d");
    Tree t4 = new Tree("e");
    Tree t5 = new Tree("f");
    Tree t6 = new Tree("g");
    Tree t7 = new Tree("h");
    Tree t8 = new Tree("i");

    root.left = t1;
    root.right = t2;
    t1.left = t3;
    t1.right = t4;
    t1.parent = root;

    t2.left = t5;
    t2.right = t6;
    t2.parent = root;

    t3.parent = t1;
    t4.parent = t1;

    t5.parent = t2;
    t6.parent = t2;

    t4.left = t7;
    t4.right = t8;
    t7.parent = t4;
    t8.parent = t4;

    Tree t = getNextNode(t6);
    if (t == null) {
      System.out.println("null");
    } else {
      System.out.println(t.value);
    }
  }

  private Tree getNextNode(Tree tree) {
    if (tree == null) {
      return null;
    }

    Tree next = null;

    if (tree.right != null) { // 有右子树 下一个为最左边的
      Tree rightTree = tree.right;
      while (rightTree.left != null) {
        rightTree = rightTree.left;
      }
      next = rightTree;
    } else if (tree.parent != null) { // 有父亲节点
      Tree current = tree;
      Tree parent = tree.parent;
      while (parent != null
          && current == parent.right) { // 有父亲节点 且该节点为父亲节点的右节点 则往上找 一直找到可以作为父亲节点的左子树时 该父节点为下一个节点
        current = parent;
        parent = parent.parent;
      }
      next = parent;
    }
    return next;
  }

  class Tree {
    String value;
    Tree left;
    Tree right;
    Tree parent;

    public Tree(String value) {
      this.value = value;
    }
  }
}
