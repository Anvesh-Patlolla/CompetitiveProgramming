package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class LETTERPHONE {

  HashMap<Character, String> map = null;

  public ArrayList<String> letterCombinations(String input) {
    map = new HashMap<>();

    map.put('0', "0");
    map.put('1', "1");
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    ArrayList<String> str = new ArrayList<String>();
    for (int i = 0; i < input.length(); i++) {
      str.add(map.get(input.charAt(i)));
    }
    int strLen = str.size();
    int lastIndex = str.get(strLen - 1).length();
    calculate("", str, 0, 0, strLen, lastIndex);

    return output;

  }

  ArrayList<String> output = new ArrayList<String>();


  private void calculate(String out, ArrayList<String> str, int currentStr, int currentIndex,
      int strLen, int lastIndex) {
    if (currentStr >= strLen) {
      // System.out.println(out);
      output.add(out);
      return;
    }
    String out1 = str.get(currentStr);
    for (int i = 0; i < out1.length(); i++) {
      calculate(out + out1.charAt(i), str, currentStr + 1, currentIndex, strLen, lastIndex);
    }
  }

  public static void main(String[] args) {
    LETTERPHONE obj = new LETTERPHONE();
    obj.letterCombinations("0123");
    obj.display();
  }

  private void display() {
    for (String s : output) {
      System.out.println(s);
    }
    // System.out.println("END");
  }
}
