package interviewbit;

public class Regex {
  public int isMatch(final String s, final String p) {
    // if (s.matches(p)) {
    // return 1;
    // }
    if (computeMatchDP(s, p, 0, 0)) {
      return 1;
    }
    return 0;
  }



  private boolean computeMatchDP(String s, String p, int startS, int startP) {

    boolean array[][] = new boolean[p.length() + 1][s.length() + 1];
    array[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      for (int j = 1; j <= s.length(); j++) {
        if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') {
          array[i][j] = array[i - 1][j - 1];
        } else if (p.charAt(i - 1) == '*') {
          array[i][j] = array[i - 1][j] || array[i][j - 1] || array[i - 1][j - 1];
          if (array[i][j]) {
            array[i][0] = true;
          }
        }

      }
    }
    return array[p.length()][s.length()];

  }

  private boolean computeMatch(String input, String pattern, int currentInputIndex,
      int currentPatternIndex) {
    if (input.length() == currentInputIndex && pattern.length() == currentPatternIndex) {
      return true;
    }

    if (input.length() == currentInputIndex || pattern.length() == currentPatternIndex) {
      return false;
    }


    if (pattern.length() == currentPatternIndex + 1) {
      if (pattern.charAt(currentPatternIndex) == '*') {
        return true;
      }
      if (input.length() == currentInputIndex + 1) {
        if (input.charAt(currentInputIndex) == pattern.charAt(currentPatternIndex)
            || pattern.charAt(currentPatternIndex) == '?') {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }

    }

    char currentP = pattern.charAt(currentPatternIndex);
    if (currentP == '?') {
      return computeMatch(input, pattern, currentInputIndex + 1, currentPatternIndex + 1);
    }
    if (currentP == '*') {
      boolean t1 = computeMatch(input, pattern, currentInputIndex + 1, currentPatternIndex);
      boolean t2 = computeMatch(input, pattern, currentInputIndex + 1, currentPatternIndex + 1);
      boolean t3 = computeMatch(input, pattern, currentInputIndex, currentPatternIndex + 1);
      return t1 || t2 || t3;
    }

    if (input.charAt(currentInputIndex) == pattern.charAt(currentPatternIndex)) {
      return computeMatch(input, pattern, currentInputIndex + 1, currentPatternIndex + 1);
    }

    return false;
  }

  public static void main(String[] args) {
    Regex obj = new Regex();
    // String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    // String p = "*b";
    // String p =
    // "a**************************************************************************************";

    // String s = "cc";
    // String p = "***??";
    String s = "acba";
    String p = "*?b*a*ba*";
    System.out.println(obj.isMatch(s, p));

  }
}
