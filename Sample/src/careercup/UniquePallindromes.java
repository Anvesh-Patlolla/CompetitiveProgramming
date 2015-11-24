package careercup;

import java.util.HashSet;

public class UniquePallindromes {


  static int palindrome(String str) {
    int length = str.length();
    HashSet<String> set = new HashSet<String>();
    for (int i = 0; i < length; i++) {
      for (int j = i; j < length; j++) {
        if (isPallindome(str, i, j)) {
          set.add(new String(str.substring(i, j + 1)));
        }
      }
    }

    return set.size();
  }

  private static boolean isPallindome(String str, int m, int n) {
    if (m == n) {
      return true;
    }
    for (int i = m, j = n; i < (m + n) / 2+1; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }

    return true;
  }
  public static void main(String[] args) {
    System.out.println(palindrome("aabaa"));
  }
}
