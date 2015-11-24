package interviewbit;

public class ReverseBits {

  long reverse(long input) {
    int[] array = new int[32];

    for (int i = 0; i < array.length; i++) {
      if (input % 2 == 1) {
        array[i] = 1;
      }
      input = input / 2;
    }

    long retVal = 0;
    for (int i = 0; i < array.length; i++) {
      retVal = retVal*2+ array[i];
    }
    return retVal;
  }

  public static void main(String[] args) {
    ReverseBits obj = new ReverseBits();
    System.out.println(obj.reverse(3));
  }
}
