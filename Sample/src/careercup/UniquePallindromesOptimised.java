package careercup;

import java.util.HashSet;

public class UniquePallindromesOptimised {

  public static void main(String[] args) {
    System.out.println(palindrome("aabaa"));
  }

  private static int palindrome(String str) {

    int n = str.length();
    HashSet<String> UniqueSubstrings = new HashSet<>();
    boolean[][] T = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      T[i][i] = true;
      UniqueSubstrings.add("" + str.charAt(i));
    }
    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        T[i][i + 1] = true;
        UniqueSubstrings.add(str.substring(i, i + 2));
      }
    }
    int j;
    for (int len = 3; len <= n; len++) {
      for (int k = 0; k < n - len + 1; k++) {
        j = k + len - 1;
        if (str.charAt(k) == str.charAt(j) && T[k + 1][j - 1]) {
          T[k][j] = true;
          UniqueSubstrings.add(str.substring(k, j + 1));
        }
      }
    }

    return UniqueSubstrings.size();
  }
}
