package interviewbit;

public class ATOI {
  public int atoi(final String a) {
    long retVal = 0;
    int sign = 1;
    boolean numberStarted = false;
    boolean signDetected = false;
    for (int i = 0; i < a.length(); i++) {

      int num = a.charAt(i) - '0';

      if (signDetected || numberStarted) {
        if (num >= 0 && num < 10) {
          retVal = retVal * 10 + num;
          if (retVal > Integer.MAX_VALUE || retVal < Integer.MIN_VALUE) {
            break;
          }
        } else {
          break;
        }
      } else {
        if (a.charAt(i) == ' ') {
          continue;
        } else {
          if (a.charAt(i) == '+') {
            signDetected = true;
            numberStarted = true;
          } else if (a.charAt(i) == '-') {
            signDetected = true;
            numberStarted = true;
            sign = -1;
          } else if (num > -1 && num < 10) {
            signDetected = true;
            numberStarted = true;

            retVal = retVal * 10 + num;
          }

          else {
            break;
          }
        }
      }
    }
    if (retVal > Integer.MAX_VALUE || retVal < Integer.MIN_VALUE) {
      if (retVal > Integer.MAX_VALUE) {
        if (sign == -1) {
          return Integer.MIN_VALUE;
        } else {
          return Integer.MAX_VALUE;
        }
      } else {
        if (sign == 1) {
          return Integer.MIN_VALUE;
        } else {
          return Integer.MAX_VALUE;
        }
     
      }
    }
    return ((int) retVal) * sign;
  }

  public static void main(String[] args) {
    ATOI obj = new ATOI();
    System.out.println(obj.atoi(""));
    System.out.println(obj.atoi(" 1"));
    System.out.println(obj.atoi("-123"));
    System.out.println(obj.atoi("123"));
    System.out.println(obj.atoi("  12"));
    System.out.println(obj.atoi("+123"));
    System.out.println(obj.atoi("-123"));
    System.out.println(obj.atoi("  -123"));

    System.out.println(obj.atoi("asfdg123"));
    System.out.println(obj.atoi("asfgg 123"));
    System.out.println(obj.atoi("+123asff"));
    System.out.println(obj.atoi("+123 asff"));
    System.out.println(obj.atoi("-123 asff"));
    System.out.println(obj.atoi("-0 asff"));
    System.out.println(obj.atoi("+0 asff"));
    System.out.println(obj.atoi("+01244 asff"));
    System.out.println(obj.atoi("+0123456789023456 asff"));
    System.out.println(obj.atoi("-012345678903456 asff"));
  }
}
