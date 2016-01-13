package madhu.aerospike;


public class IsItPossible {

  public static void main(String[] args) {
    System.out.println(isitpossible(1, 4, 5, 9));
  }

  static String isitpossible(int a, int b, int c, int d) {
    return isit(a, b, c, d) ? "Yes" : "No";
  }

  static boolean isit(int a, int b, int c, int d) {
    if (a > c || b > d)
      return false;
    if (a == c && b == d)
      return true;
    boolean left = isit(a + b, b, c, d);
    boolean right = isit(a, a + b, c, d);
    return left || right;
  }
}
