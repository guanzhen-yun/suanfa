package com.tantan.suanfa.test;

import androidx.annotation.NonNull;

/** 链表 */
public class ListNode {

  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
  }

  @NonNull
  @Override
  public String toString() {
    return "" + value;
  }
}
