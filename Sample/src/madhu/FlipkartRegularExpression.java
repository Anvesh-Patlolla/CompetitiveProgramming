package madhu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipkartRegularExpression {
  private static final Character START = '$';
  private static final Character END = '^';
  private static final Character DOT = '.';
  private static final Character STAR = '*';

  public static void main(String[] args) {
    FlipkartRegularExpression instance = new FlipkartRegularExpression();
    System.out.println("Regular Expression : \n");
    String regularExpression = instance.inputFromKeyboard();
    System.out.println("INPUT STRING : \n");
    String input = instance.inputFromKeyboard();
    System.out.println("regular Expression: " + regularExpression + " input :" + input);
    System.out.println(instance.validateRegularExpression(regularExpression, input));

  }

  private boolean validateRegularExpression(String regularExpression, String input) {
    boolean isValidate = validateRegularExpression(regularExpression, input, 0, 0);
    return isValidate;
  }

  private boolean validateRegularExpression(String regularExpression, String input, int regIndex,
      int inpIndex) {
    if (regIndex >= regularExpression.length() && inpIndex >= input.length()) {
      return true;
    }
    if (regIndex >= regularExpression.length() || inpIndex >= input.length()) {
      return false;
    }

    Character currentChar = regularExpression.charAt(regIndex);
    // check the current char.
    boolean isValidate = false;
    if (currentChar == START) {
      // If the first char equals $ then use start condition - dollar condition
      isValidate = validateDollar(regularExpression, input, regIndex, inpIndex);
    } else if (currentChar == END) {
      isValidate = validateEnd(regularExpression, input, regIndex, inpIndex);
    } else if (currentChar == DOT) {
      isValidate = validateDot(regularExpression, input, regIndex, inpIndex);
    } else if (currentChar == STAR) {
      isValidate = validateSTAR(regularExpression, input, regIndex, inpIndex);
    } else {
      isValidate = validateLetters(regularExpression, input, regIndex, inpIndex);
    }
    return isValidate;

  }

  private boolean validateLetters(String regularExpression, String input, int regIndex, int inpIndex) {
    int i, j = 0;
    for (i = regIndex, j = inpIndex; j < input.length() && i < regularExpression.length(); i++, j++) {
      if (regularExpression.charAt(i) != input.charAt(j)) {
        break;
      }
    }
    boolean isValidate = validateRegularExpression(regularExpression, input, i, j);
    return isValidate;
  }

  private boolean validateSTAR(String regularExpression, String input, int regIndex, int inpIndex) {
    Character repeatingChar = regularExpression.charAt(regIndex - 1);
    int i = 0;
    boolean isValidate = false;
    for (i = inpIndex; i < input.length(); i++) {
      if (repeatingChar != input.charAt(i)) {
        break;
      }
      isValidate =
          isValidate || validateRegularExpression(regularExpression, input, regIndex + 1, i - 1);
    }
    if (i == input.length() - 1 && regIndex == regularExpression.length() - 1) {
      return true;
    }

    return isValidate;
  }



  private boolean validateDot(String regularExpression, String input, int regIndex, int inpIndex) {
    boolean isValidate = false;
    if (input.length() > inpIndex) {
      isValidate = true;
    } else {
      return false;
    }
    isValidate = validateRegularExpression(regularExpression, input, regIndex + 1, inpIndex + 1);
    return isValidate;
  }

  private boolean validateEnd(String regularExpression, String input, int regIndex, int inpIndex) {
    if (inpIndex == input.length() - 1) {
      return true;
    } else {
      return false;
    }
  }

  private boolean validateDollar(String regularExpression, String input, int regIndex, int inpIndex) {
    boolean isValidate = false;
    regIndex++;
    if (input.charAt(inpIndex) == regularExpression.charAt(regIndex)) {
      isValidate = true;
    } else {
      return false;
    }
    isValidate = validateRegularExpression(regularExpression, input, regIndex + 1, inpIndex + 1);
    return isValidate;
  }

  public String inputFromKeyboard() {
    InputStreamReader in = null;
    in = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(in);
    String s = null;
    try {
      s = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return s;
  }


}
