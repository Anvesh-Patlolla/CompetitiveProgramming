package tbd;

public class FindStringLength {

  int calculateStringLength(String input) {

    int retVal = 0;
    if (input == null) {
      return retVal;
    }
    retVal = calculateStringLength(input, 1, Integer.MAX_VALUE);
    return retVal;
  }


  private int calculateStringLength(String input, int start, int maxValue) {
    if (start == maxValue) {
      return start;
    }

    int retVal = 0;
    int mid = start + (maxValue - start) / 2;
    try {

      input.charAt(mid);
      retVal = calculateStringLength(input, mid + 1, maxValue);
    } catch (StringIndexOutOfBoundsException e) {
      retVal = calculateStringLength(input, start, mid - 1);
    }

    return retVal;
  }

  public static void main(String[] args) {
    FindStringLength obj = new FindStringLength();
    String input = "";
    System.out.println(obj.calculateStringLength(input));
    System.out.println(obj.calculateStringLength("1"));
    System.out.println(obj.calculateStringLength("123"));
    System.out.println(obj.calculateStringLength("123456"));
  }
}
