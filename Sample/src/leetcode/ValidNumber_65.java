package leetcode;

// Solution
public class ValidNumber_65 {

  public boolean isNumber(String s) {
    if (s.equals(" ") || s.equals(".")) {
      return false;
    }
    boolean minus = false;
    boolean exponential = false;
    boolean startingSpace = false;
    boolean endingSpace = false;
    boolean onlyNumberOrExpExpected = false;
    boolean decimal = false;
    boolean crossedAtleastoneNumber = false; // for case of e9=> false;
    boolean justPassedeExpectingNumber = false;
    boolean justPassedDecimalExpectingNumber = false;

    boolean justPassedSignExpectingImediateNumber = false;

    for (int i = 0; i < s.length(); i++) {
      if (justPassedSignExpectingImediateNumber) {

        if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) == '.')) {
          justPassedSignExpectingImediateNumber = false;
        } else {
          return false;
        }
      }
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        onlyNumberOrExpExpected = true;
        crossedAtleastoneNumber = true;
        minus = true;
        if (endingSpace) {
          return false;
        }
        if (justPassedeExpectingNumber) {
          justPassedeExpectingNumber = false;
        }
        if (justPassedDecimalExpectingNumber) {
          justPassedDecimalExpectingNumber = false;
        }


      } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
        if (minus) {
          return false;
        }
        minus = true;
        justPassedSignExpectingImediateNumber = true;
      } else if (s.charAt(i) == ' ') {
        if (!onlyNumberOrExpExpected) {
          startingSpace = true;
        } else {
          startingSpace = true;
          exponential = true;
          decimal = true;
          endingSpace = true;
          minus = true;
        }
      } else if (s.charAt(i) == 'e') {
        if (exponential || !crossedAtleastoneNumber) {
          return false;
        }
        exponential = true;
        onlyNumberOrExpExpected = true;
        decimal = true;
        startingSpace = true;
        justPassedeExpectingNumber = true;
        minus = true;
        if (i + 1 < s.length() && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+')) {
          i++;
        }
      } else if (s.charAt(i) == '.') {
        if (decimal) {
          return false;
        }
        decimal = true;
        onlyNumberOrExpExpected = true;
        startingSpace = true;
        justPassedDecimalExpectingNumber = true;
        minus = true;
      } else {
        return false;
      }
    }

    if (justPassedeExpectingNumber || justPassedSignExpectingImediateNumber) {
      return false;
    }
    if (startingSpace && !crossedAtleastoneNumber) {
      return false;
    }
    return true;

  }
}
