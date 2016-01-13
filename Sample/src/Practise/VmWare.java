package Practise;

import java.util.LinkedHashMap;

public class VmWare {

  static String compress(String str) {
    StringBuffer retVal = new StringBuffer();
    char prev = str.charAt(0);
    int count = 0;
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      /*
       * if (prev == ch) { count++; } else { if (count == 0) { retVal.append(ch); } else {
       * retVal.append(ch).append(count); } count =0; } prev = ch;
       */
      if (map.get(ch) == null) {
        map.put(ch, 1);
      } else {
        int counter = map.get(ch);
        map.put(ch, counter + 1);
      }
      boolean flag = true;
      if ((prev != ch)) {
        flag = false;
        if (map.get(prev) != null) {
          int c = map.get(prev);
          retVal.append(prev);
          if (c != 1) {
            retVal.append(c);
          }
        }

        map.remove(prev);
      }

      if (flag && (i == str.length() - 1)) {
        int c = map.get(ch);
        retVal.append(ch).append(c);
      }
      if ((i == str.length() - 1) && prev != ch) {
        retVal.append(ch);
      }


      prev = ch;

    }/*
      * Iterator<Entry<Character, Integer>> it = map.entrySet().iterator(); while (it.hasNext()) {
      * Map.Entry<Character, Integer> pair = (Entry<Character, Integer>) it.next(); char key =
      * pair.getKey(); int value = pair.getValue(); System.out.println(key + " = " + value);
      * retVal.append(key); if (value != 1) { retVal.append(value); } it.remove(); }
      */
    return new String(retVal);
  }

  public static void main(String[] args) {
    // System.out.println(compress("aaaaabbbbbcccdeeeepqrstv"));
    System.out.println(compress("stv"));
    System.out.println(compress("aaaaabbbbbbbbbccccpqqrstuvasdfghj"));

  }
}
