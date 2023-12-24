package com.tantan.suanfa.others;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * 相对名次 map 映射  排序
 */
public class Mingci {

  @Test
  public void main() {
    int[] score = new int[]{10, 3, 8, 9, 4};  // 10 9 8 4 3  1 2 3 4 5
    String[] strings = mingci(score);
    for (int i = 0; i < strings.length; i++) {
      System.out.println(strings[i]);
    }
  }

  private String[] mingci(int[] score) {
    String[] strings = new String[score.length];
    Map<Integer, Integer> map_score = new HashMap<>();
    int[] score_old = new int[score.length];
    for (int i = 0; i < score.length; i++) {
      score_old[i] = score[i];
    }
    sort(score);
    for (int i = 0; i < score.length; i++) { //10 -->1  9 -->2  8 -->3 4 -->4  3 -->5
      map_score.put(score[i], score.length - i);
    }
    for (int i = 0; i < score_old.length; i++) {
      strings[i] = "" + map_score.get(score_old[i]);
    }
    return strings;
  }

  private void sort(int[] score) {
    for (int i = 0; i < score.length; i++) {
      for (int j = i + 1; j < score.length; j++) {
        if (score[j] < score[i]) {
          int temp = score[i];
          score[i] = score[j];
          score[j] = temp;
        }
      }
    }
  }
}
