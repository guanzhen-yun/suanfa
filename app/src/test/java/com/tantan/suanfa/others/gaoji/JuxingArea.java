package com.tantan.suanfa.others.gaoji;

import org.junit.Test;

/**
 * 矩形面积
 */
public class JuxingArea {

  @Test
  public void main() {
    //左下  右上
    int[] array1 = new int[]{-2, -2, 2, 2};
    int[] array2 = new int[]{-2, -2, 2, 2};
    System.out.println(getArea(array1, array2));
  }

  private int getArea(int[] array1, int[] array2) {
    int ay1 = array1[1];
    int ay2 = array1[3];

    int by1 = array2[1];
    int by2 = array2[3];

    int ax1 = array1[0];
    int ax2 = array1[2];

    int bx1 = array2[0];
    int bx2 = array2[2];

    int height = 0;
    int width = 0;

    if (ay1 < by1) {
      int beblow = by1 - ay1;
      if (ay2 > by2) {
        height = by1 - by2;
      } else if (ay2 < by1) {
        height = 0;
      } else {
        height = ay2 - beblow - ay1;
      }
    } else {
      if (ay1 > by2) {
        height = 0;
      } else if (ay2 > by2) {
        int top = ay2 - by2;
        height = ay2 - top - ay1;
      } else {
        height = ay2 - ay1;
      }
    }

    if (ax1 < bx1) {
      if (ax2 < bx1) {
        width = 0;
      } else if (ax2 < bx2) {
        int left = bx1 - ax1;
        width = ax2 - ax1 - left;
      } else {
        width = bx2 - bx1;
      }
    } else {
      if (ax1 > bx2) {
        width = 0;
      } else if (ax2 < bx2) {
        width = ax2 - ax1;
      } else {
        int right = ax2 - bx2;
        width = ax2 - ax1 - right;
      }
    }

    int area = width * height;
    int area1 = (ax2 - ax1) * (ay2 - ay1);
    int area2 = (bx2 - bx1) * (by2 - by1);
    return area1 + area2 - area;
  }
}
