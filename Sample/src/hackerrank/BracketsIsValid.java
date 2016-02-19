package hackerrank;

import java.util.HashMap;
import java.util.Stack;

public class BracketsIsValid {
  static HashMap<Character, Character> map = null;

  static String[] Braces(String[] values) {
    map = new HashMap<Character, Character>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    String retVales[] = new String[values.length];
    int i = 0;
    for (String s : values) {
      retVales[i] = calculate(s);
      i++;
    }


    return retVales;


  }

  private static String calculate(String input) {

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      if (stack.size() != 0 && stack.peek() == map.get(input.charAt(i))) {
        stack.pop();
      } else {
        stack.push(input.charAt(i));
      }
    }


    return stack.size() == 0 ? "YES" : "NO";
  }

  public static void main(String[] args) {
    String[] values = new String[4];
    values[0] = "()";
    values[1] = "{()}";
    values[2] = "{)";
    values[3] = "[]({}()[])";
    display(Braces(values));
  }

  private static void display(String[] braces) {

    for (String s : braces) {
      System.out.println(s);
    }
    return;
  }
}
