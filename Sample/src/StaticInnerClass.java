public class StaticInnerClass {
  public static void main(String[] args) {

  }

  static int a = 0;

  class Inner {
    int k = 0;

    int method() {
      return a + k;
    }

  }
  static class StaticInner {
    int l = 0;

    int method2() {
      l = l + a; // works only if a is static
      return l;
    }
  }

}
