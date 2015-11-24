package hackerrank.zenefitsCodeSprint;

import java.util.Scanner;

// Solution
public class EncryptionModule {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String P = in.next();
      String E = in.next();
      int retVal = calculate(P, E);
      System.out.println(retVal);
    }


  }

  private static int calculate(String p, String e) {
    // char input[] = p.toCharArray();

    int size = p.length();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 27; i++) {
      int count = 0;
      for (int j = 0; j < size; j++) {
        if ((p.charAt(j) + i -'a')%26 == e.charAt(j) -'a') {
          //
          //System.out.println("no");
        } else {
          count++;
        }
      }
      if (count == 0) {
        return 0;
      }

      if (count < min) {
        min = count;
      }
    }
    return min;
  }
}
