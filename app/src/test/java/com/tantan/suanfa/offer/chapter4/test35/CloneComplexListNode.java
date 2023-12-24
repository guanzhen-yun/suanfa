package com.tantan.suanfa.offer.chapter4.test35;

import org.junit.Test;

/** 复杂链表的复制 */
public class CloneComplexListNode {

  @Test
  public void main() {
    ComplexListNode complexListNode = createComplexListNode();
    copyComplexNode(complexListNode);
    siblingNode(complexListNode);
    ComplexListNode node = getCloneListNode(complexListNode);
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
  }

  // 1 1 2 2 3 3 4 4 5 5
  private ComplexListNode getCloneListNode(ComplexListNode complexListNode) {
    if (complexListNode == null) {
      return null;
    }
    ComplexListNode headNode = complexListNode;
    ComplexListNode lastNode = null;
    ComplexListNode copyNode = null;

    while (headNode != null) {
      if (copyNode == null) {
        copyNode = headNode.next;
        lastNode = headNode.next;
      } else {
        copyNode.next = headNode.next;
        copyNode = copyNode.next;
      }
      headNode.next = copyNode.next;
      headNode = headNode.next;
    }

    return lastNode;
  }

  private void siblingNode(ComplexListNode complexListNode) {
    ComplexListNode headNode = complexListNode;
    while (headNode != null) {
      if (headNode.sibling != null) {
        headNode.next.sibling = headNode.sibling.next;
      }
      headNode = headNode.next.next;
    }
  }

  private void copyComplexNode(ComplexListNode complexListNode) {
    ComplexListNode headNode = complexListNode;
    while (headNode != null) {
      ComplexListNode node = new ComplexListNode(headNode.value);
      node.next = headNode.next;
      headNode.next = node;
      headNode = node.next;
    }
  }

  private ComplexListNode createComplexListNode() {
    ComplexListNode complexListNode1 = new ComplexListNode(1);
    ComplexListNode complexListNode2 = new ComplexListNode(2);
    ComplexListNode complexListNode3 = new ComplexListNode(3);
    ComplexListNode complexListNode4 = new ComplexListNode(4);
    ComplexListNode complexListNode5 = new ComplexListNode(5);
    complexListNode1.next = complexListNode2;
    complexListNode2.next = complexListNode3;
    complexListNode3.next = complexListNode4;
    complexListNode4.next = complexListNode5;
    complexListNode1.sibling = complexListNode3;
    complexListNode4.sibling = complexListNode2;
    complexListNode2.sibling = complexListNode5;
    return complexListNode1;
  }

  class ComplexListNode {
    public int value;
    public ComplexListNode next;
    public ComplexListNode sibling;

    public ComplexListNode(int value) {
      this.value = value;
    }
  }
}
