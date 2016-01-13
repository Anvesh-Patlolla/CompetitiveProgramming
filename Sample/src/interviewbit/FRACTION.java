package interviewbit;

public class FRACTION {

  public String fractionToDecimal(int numerator, int denominator) {

    double fraction = ((double) numerator / denominator);
    String s = Double.toString(fraction);
    System.out.println(s);

    return calculate(s);
  }

  private String calculate(String s) {
    StringBuilder mantessa = new StringBuilder();
    StringBuilder decimal = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {

    }
    return null;
  }

  public static void main(String[] args) {
    FRACTION obj = new FRACTION();
    obj.fractionToDecimal(-1, -2147483648);
  }
}
