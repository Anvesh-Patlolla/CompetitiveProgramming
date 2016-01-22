package leetcode;

public class Shortest_Palindrome_214 {

  public String shortestPalindrome(String s) {
    
    for (int i = s.length() - 1; i > -1; i--) {
      if (isPallindrome(s, 0, i)) {
        StringBuilder sb = new StringBuilder();
        for (int j = s.length() - 1; j > i; j--) {
          sb.append(s.charAt(j));
        }
        sb.append(s);
        return sb.toString();
      }
    }
    return s;

  }

  private boolean isPallindrome(String s, int start, int end) {
    for (int i = start, j = end; j >= i; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Shortest_Palindrome_214 obj = new Shortest_Palindrome_214();
    System.out.println(obj.shortestPalindrome("aacecaaa"));
    System.out.println(obj.shortestPalindrome("abcd"));
  }
}
