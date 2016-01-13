package venky.knowlarity;

import java.util.Scanner;

// Solution
public class StringSimilarity {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      String s = sc.next();
      int ret = calculate(s);
      System.out.println(ret);


    }
  }

  private static int calculate(String s) {
    int count = 0;
    for (int i = 1; i < s.length(); i++) {
      boolean flag = true;
      for (int j = 0, k = i; flag && k < s.length() && j < s.length(); j++, k++) {
        if (s.charAt(j) == s.charAt(k)) {
          count++;
        } else {
          flag = false;
        }
      }
    }
    return count + s.length();
  }
}
