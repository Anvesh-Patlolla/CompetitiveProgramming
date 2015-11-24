package careercup;

import java.util.HashSet;

public class UniquePallindromeWithPivot {
  public static void main(String[] args) {
    System.out.println(palindrome("aabaaa"));

    System.out.println(palindrome("a"));
  }

  static HashSet<String> set = null;

  private static int palindrome(String string) {
    set = new HashSet<>();
    for (int i = 0; i < string.length(); i++) {
      evenCase(string, i);
      oddcase(string, i);
    }
    return set.size();
  }

  private static void oddcase(String string, int m) {
    set.add("" + string.charAt(m));
    testCase(string, m - 1, m + 1);
  }

  private static void testCase(String string, int i, int j) {
    int length = string.length();
    if (i < 0 || j >= length) {
      return;
    }
    if (string.charAt(i) == string.charAt(j)) {
      set.add(string.substring(i, j + 1));
      testCase(string, i - 1, j + 1);
    }
  }

  private static void evenCase(String string, int m) {
    testCase(string, m - 1, m);
  }
}
