package interviewbit;

public class VERSION {
  public int compareVersion(String a, String b) {
    if (a.equals(b)) {
      return 0;
    }
/*    int i = 0, j = 0;
    for (i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
      if (a.charAt(i) == '.' && b.charAt(j) == '.') {
        continue;
      } else if (a.charAt(i) == '.' || b.charAt(j) == '.') {
        if (a.charAt(i) == '.') {
          if (getVal(b, j) != 0) {
            return -1;
          } else {
            return 0;
          }
        }
        if (b.charAt(j) == '.') {
          if (getVal(a, i) != 0) {
            return 1;
          } else {
            return 0;
          }
        }
      }
      if (a.charAt(i) > b.charAt(j)) {
        return 1;
      } else if (a.charAt(i) < b.charAt(j)) {
        return -1;
      }

    }
    //if(a.charAt(i) == )
    int tempSize = a.length() - b.length();
    if (tempSize == 0) {
      return 0;
    } else if (tempSize > 0) {
      return 1;
    } else {
      return -1;
    }*/
    // size case..
     return calculate(a, 0, b, 0);
  }

  private int getVal(String b, int j) {
    int temp = 0;
    for (int i = j + 1; i < b.length() && b.charAt(i) != '.'; i++) {
      temp = temp * 10 + b.charAt(i) - '0';
    }
    return temp;
  }

  private int calculate(String a, int startA, String b, int startB) {
    long tempA = 0;
    int varA = 0;
    if (startA >= a.length() && startB >= b.length()) {
      return 0;
    } /*
       * else if (startA >= a.length() || startB >= b.length()) { if (startA >= a.length()) { return
       * -1; } else { return 1; } }
       */
    for (varA = startA; varA < a.length() && a.charAt(varA) != '.'; varA++) {
      tempA = tempA * 10 + a.charAt(varA) - '0';
    }
    long tempB = 0;
    int varB = 0;
    for (varB = startB; varB < b.length() && b.charAt(varB) != '.'; varB++) {
      tempB = tempB * 10 + b.charAt(varB) - '0';
    }
    if (tempA > tempB) {
      return 1;
    } else if (tempB > tempA) {
      return -1;
    } else {
      return calculate(a, varA + 1, b, varB + 1);
    }
  }

  public static void main(String[] args) {
    VERSION obj = new VERSION();
    //System.out.println(obj.compareVersion("444444444444444444444444", "4444444444444444444444444"));
    System.out.println(obj.compareVersion("1", "1.0"));

  }
}
