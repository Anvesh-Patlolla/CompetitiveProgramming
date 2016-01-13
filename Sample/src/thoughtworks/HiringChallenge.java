package thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// CandidateCode
public class HiringChallenge {

  static HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
  static TreeMap<Character, Integer> sortedFrequency = null;
  static HashMap<Character, String> encode = null;

  public static void main(String[] args) {
    String input = inputFromKeyboard();
    constructTree(input);
  }

  // public static String constructTree(String input1)
  public static String constructTree(String input) {
    for (int i = 0; i < input.length(); i++) {
      Character currentChar = input.charAt(i);
      if (frequency.containsKey(currentChar) == true) {
        int freq = frequency.get(currentChar);
        frequency.put(currentChar, freq + 1);
      } else {
        frequency.put(currentChar, 1);
      }
    }
    CustomComparator comparator = new CustomComparator(frequency);
    sortedFrequency = new TreeMap<Character, Integer>(comparator);
    sortedFrequency.putAll(frequency);
    encode = new HashMap<Character, String>();
    String s = "0";
    int i = 0;
    for (Map.Entry<Character, Integer> c : sortedFrequency.entrySet()) {
      // System.out.println(" " + c.getKey() + " : " + c.getValue());
      if (i == 0) {
        encode.put(c.getKey(), s);
      } else if (i == sortedFrequency.size() - 1) {
        String s1 = generateOnes(i);
        encode.put(c.getKey(), s1);
      } else {
        s = "1" + s;
        encode.put(c.getKey(), s);
      }
      i++;
      // System.out.println("ENCODE " + c.getKey() + " : " + encode.get(c.getKey()));
    }
    return encode(input);
  }


  private static String encode(String input) {
    StringBuffer retVal = new StringBuffer();
    for (int i = 0; i < input.length(); i++) {
      String enc = encode.get(input.charAt(i));
      retVal.append(enc);
    }

    // System.out.println(/*"FINAL ENCODED STRING :" +*/ retVal.toString());
    return retVal.toString();
  }

  private static String generateOnes(int num) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < num; i++) {
      builder.append(1);
    }
    return builder.toString();
  }

  private static String inputFromKeyboard() {
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

  static class CustomComparator implements Comparator<Character> {

    HashMap<Character, Integer> map = null;

    public CustomComparator(HashMap<Character, Integer> input) {
      map = input;
    }

    @Override
    public int compare(Character o1, Character o2) {

      if (map.get(o1).compareTo(map.get(o2)) == 0) {
        if (o1.compareTo(o2) > 0) {
          return 1;
        } else {
          return -1;
        }
      } else if (map.get(o1).compareTo(map.get(o2)) > 0) {
        return -1;
      } else {
        return 1;
      }
    }
  }
}
