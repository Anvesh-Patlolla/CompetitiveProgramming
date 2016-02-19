package hackerrank;

public class SuperPrime {
  static int superPower(int z) {

    for (int i = 2; i <= Math.sqrt(z); i++) {
      for (int j = 1; ((int) Math.pow(i, j)) <= z; j++) {
        if (((int) Math.pow(i, j)) == z) {
          return 1;
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    SuperPrime obj = new SuperPrime();
    System.out.println(obj.superPower(2));
    System.out.println(obj.superPower(30));
    System.out.println(obj.superPower(27));
    System.out.println(obj.superPower(8));
    System.out.println(obj.superPower(9));

  }
}
