package hackerrank;

public class PlusMultArray {
  static String plusMult(int[] A) {
    long even = 0;

    int odd = 0;

    int temp = 0;

    if (A[0] % 2 == 0) {
      even = 1;
    }
    if (A[1] % 2 == 0) {
      odd = 1;
    }
    // 1 => vlue is even
    // 0 => val is odd
    for (int i = 2, count = 0; i < A.length; i = i + 2, count++) {
      if (i < A.length) {
        if (count % 2 == 0) {
          if (even == 1 || A[i] % 2 == 0) {
            even = 1;
          } else {
            even = 0;
          }
        } else {
          if (even == 0 || A[i] % 2 == 1) {
            even = 0;
          } else {
            even = 1;
          }
        }
      }
      // even %= 2;
    }

    for (int i = 3, count = 0; i < A.length; i = i + 2, count++) {
      if (i < A.length) {
        if (count % 2 == 0) {
          if (odd == 1 || A[i] % 2 == 0) {
            odd = 1;
          } else {
            odd = 0;
          }
        } else {
          if (odd == 0 || A[i] % 2 == 1) {
            odd = 0;
          } else {
            odd = 1;
          }
        }
      }

      // even %= 2;
    }
    System.out.println("odd:" + odd + "  -Even:" + even);
    odd %= 2;
    even %= 2;
    if (odd == even) {
      return "NEUTRAL";
    } else if (even > odd) {
      return "EVEN";
    } else {
      return "ODD";
    }

  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(plusMult(A));
  }
}
