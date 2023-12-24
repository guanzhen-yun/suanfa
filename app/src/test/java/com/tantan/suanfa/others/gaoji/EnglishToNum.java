package com.tantan.suanfa.others.gaoji;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 英文中重建数字
 */
public class EnglishToNum {

  @Test
  public void main() {
    System.out.println(getNumStr("fviefuro"));
  }

  private String getNumStr(String str) {
    List<String> list = new ArrayList<>();
    List<Integer> resultList = new ArrayList<>();
    for (int j = 0; j < str.length(); j++) {
      list.add(str.substring(j, j + 1));
    }

    List<String> numList = getNumStr();
    while (list.size() > 0) {
      for (int i = 0; i < numList.size(); i++) {
        String numStr = numList.get(i);
        int count = 0;
        for (int j = 0; j < list.size(); j++) {
          for (int k = 0; k < numStr.length(); k++) {
            if (list.get(j).equals(numStr.substring(k, k + 1))) {
              count++;
            }
          }
        }
        if (count >= numStr.length()) {
          for (int k = 0; k < numStr.length(); k++) {
            list.remove(numStr.substring(k, k + 1));
          }
          resultList.add(i);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < resultList.size(); i++) {
      sb.append(resultList.get(i));
    }
    return sb.toString();
  }

  private List<String> getNumStr() {
    List<String> numList = new ArrayList<>();
    numList.add("zero");
    numList.add("one");
    numList.add("two");
    numList.add("three");
    numList.add("four");
    numList.add("five");
    numList.add("six");
    numList.add("seven");
    numList.add("eight");
    numList.add("nine");
    return numList;
  }

}
