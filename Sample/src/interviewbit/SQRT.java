package interviewbit;

public class SQRT {
  public int sqrt(int input) {
    if (input == 0 || input == 1) {
      return input;
    }
    int retVal = 1;
   return (int) java.lang.Math.sqrt(input);
//    long multi = retVal * retVal;
//    while (multi <= input) {
//      retVal++;
//      multi = retVal * retVal;
//      if (multi == input) {
//        return retVal;
//      }
//
//    }
//
//    return retVal - 1;
  }

  public static void main(String[] args) {
    SQRT sqrt = new SQRT();
    System.out.println(sqrt.sqrt(2147483647));
    System.out.println(sqrt.sqrt(10));
    System.out.println(sqrt.sqrt(11));
    System.out.println(sqrt.sqrt(8));

  }
}
