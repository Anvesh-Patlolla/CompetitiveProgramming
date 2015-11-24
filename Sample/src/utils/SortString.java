package utils;

import java.util.Arrays;

public class SortString {

  public static String sort(String s) {

    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);
    String ret = new String(charArray);
    return ret;
    
  }
}
