package interviewbit;

import java.util.ArrayList;

public class PARENTHESIS {
  ArrayList<String> retList = null;

  public ArrayList<String> generateParenthesis(int n) {
    retList = new ArrayList<>();
    if (n <= 0) {
      return retList;
    }
    calculate(n, 0, 0, 0, "");

    return retList;
  }

  private void calculate(int n, int position, int open, int close, String s) {
    if (close == n) {
      retList.add(s);
      return;
    }
    if (open > close) {
      calculate(n, position + 1, open, close + 1, s + ")");
    }
    if (open < n) {
      calculate(n, position + 1, open + 1, close, s + "(");
    }
  }

  public static void main(String[] args) {
    PARENTHESIS obj = new PARENTHESIS();
    System.out.println(obj.generateParenthesis(3));
  }
}
