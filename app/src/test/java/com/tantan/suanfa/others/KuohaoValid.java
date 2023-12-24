package com.tantan.suanfa.others;

import java.util.Stack;
import org.junit.Test;

/**
 * 括号有效性
 */
public class KuohaoValid {

  @Test
  public void main() {
    String str = "[{}]()";
    boolean isValid = isValidKuohao(str);
    System.out.println(isValid);
  }

  private boolean isValidKuohao(String str) {
    Stack<Character> stack = new Stack<>();
    char[] chars = str.toCharArray();
    int i = 0;
    int length = chars.length;
    while (i < length) {
      if (!stack.isEmpty()) {
        if (stack.peek() == '(' && chars[i] == ')') {
          stack.pop();
          i++;
          continue;
        }
        if (stack.peek() == '{' && chars[i] == '}') {
          stack.pop();
          i++;
          continue;
        }
        if (stack.peek() == '[' && chars[i] == ']') {
          stack.pop();
          i++;
          continue;
        }
      }
      stack.push(chars[i]);
      i++;
    }
    return stack.isEmpty();
  }

}
