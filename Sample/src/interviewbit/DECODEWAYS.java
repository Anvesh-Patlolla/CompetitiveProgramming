package interviewbit;

import java.util.HashSet;

public class DECODEWAYS {
  HashSet<String> set = null;

  public int numDecodings(String a) {
    set = new HashSet<>();
    // int retVal = calculate(a, "");
    int retVal2 = 0;
    if (preprocess(a)) {
      retVal2 = calculateDp(a);
    }
    // System.out.println(set.toString());
    return retVal2;
  }

  private boolean preprocess(String a) {

    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == '0') {
        if (i == 0) {
          return false;
        }
        if (a.charAt(i - 1) - '0' > 2) {
          return false;
        }
      }
    }
    return true;
  }

  private int calculateDp(String input) {
    int size = input.length();
    int dp[] = new int[size + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= size; i++) {
      int third = (input.charAt(i - 2) - '0') * 10 + (input.charAt(i - 1) - '0');
      if (third <= 26 && third % 10 != 0 && third > 10) {
        dp[i] = dp[i - 1] + dp[i - 2];
      } else if (input.charAt(i - 1) > '0') {
        dp[i] = dp[i - 1];
      } else {
        dp[i] = 0;
      }
    }
    return dp[size];
  }

  public static void main(String[] args) {
    DECODEWAYS obj = new DECODEWAYS();
    System.out
        .println(obj
            .numDecodings("32925665678138257423442343752148360796465852883409126159293254159974370974059818198867156827877059067081419274873853679038"));
    System.out.println(obj.numDecodings("10"));
    System.out.println(obj.numDecodings("2611055971756562"));
    System.out.println(obj.numDecodings("26110559717"));

  }

  private int calculate(String input, String b) {
    if (input.length() == 0) {
      set.add(b);
      return 1;
    }
    int first = input.charAt(0) - '0';
    char c = (char) ('a' + first - 1);
    int f = calculate(input.substring(1), b + (c));
    int th = 0;
    if (input.length() > 1) {
      int second = input.charAt(1) - '0';

      int third = first * 10 + second;
      if (third < 27) {
        char c3 = (char) ('a' + third - 1);
        th = calculate(input.substring(2), b + c3);
      }
    }
    return th + f;
  }
}
