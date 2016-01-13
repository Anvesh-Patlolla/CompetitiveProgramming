package interviewbit;

public class Factorial {

  public int trailingZeroes(int input) {
    int num = 5;
    int retVal = 0;
    double count = 1;
    while (input / ((int) Math.pow(num, count)) > 0) {
      retVal += input / ((int) Math.pow(num, count));
      count++;
    }
    return retVal;
  }

  public static void main(String[] args) {
    Factorial obj = new Factorial();
    System.out.println(obj.trailingZeroes(12));
  }
}
