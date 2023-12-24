package com.tantan.suanfa.offer.chacter2.test7;

import org.junit.Test;

/**
 * 重建二叉树
 */
public class RebuildTree {

  @Test
  public void main() {
    int[] preArray = {1, 2, 4, 7, 3, 5, 6, 8};
    int[] midArray = {4, 7, 2, 1, 5, 3, 8, 6};

    BinaryTreeNode binaryTreeNode = rebuild(preArray, midArray);
    System.out.println(binaryTreeNode.value);

  }

  private BinaryTreeNode rebuild(int[] preArray, int[] midArray) {
    if (preArray == null || midArray == null) {
      return null;
    }

    return rebuilCore(preArray, 0, preArray.length - 1, midArray, 0, midArray.length - 1);
  }

  private BinaryTreeNode rebuilCore(int[] preArray, int startPre, int endPre, int[] midArray,
      int startInOrder, int endInOrder) {
    int rootValue = preArray[startPre];
    int length = preArray.length;
    BinaryTreeNode root = new BinaryTreeNode();
    root.value = rootValue;
    root.left = null;
    root.right = null;

    int rootInOrder = startInOrder;

    while (rootInOrder < length && midArray[rootInOrder] != rootValue) {
      ++rootInOrder;
    }
    int leftLength = rootInOrder - startInOrder;
    int leftPreorderEnd = startPre + leftLength;
    if (leftLength > 0) {
      root.left = rebuilCore(preArray, startPre + 1, leftPreorderEnd, midArray, startInOrder,
          rootInOrder - 1);
    }
    if (leftLength < endPre - startPre) {
      root.right = rebuilCore(preArray, leftPreorderEnd + 1, endPre, midArray, rootInOrder + 1,
          endInOrder);
    }
    return root;
  }

  class BinaryTreeNode {

    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public int value;
  }

}
