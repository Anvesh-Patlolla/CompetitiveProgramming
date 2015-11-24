package hackerrank;

import java.util.HashSet;

public class GRIDLAND {

  static String[] retVal = null;

  static String[] gridLand(String[] inp) {
    retVal = new String[inp.length];
    counter = 0;
    for (String s : inp) {
      String[] params = s.split(" ");
      int H = Integer.parseInt(params[0]);
      int V = Integer.parseInt(params[1]);
      int required = Integer.parseInt(params[2]);
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < H; i++) {
        sb.append("H");
      }
      for (int i = 0; i < V; i++) {
        sb.append("V");
      }
      current = 0;
      set = new HashSet<>();
      permutations(sb, new StringBuffer(), required);
      counter++;
    }

    return retVal;
  }

  static int current = 0;
  static HashSet<String> set = null;

  static int counter = 0;

  private static void permutations(StringBuffer sb, StringBuffer sb2, int required) {
    if (sb.length() == 0) {
      if (required == current && !set.contains(sb2.toString())) {
        // System.out.println(sb2.toString());
        retVal[counter] = sb2.toString();
      }
      if (!set.contains(sb2.toString())) {
        set.add(sb2.toString());
        current++;
      }

      return;
    }

    for (int i = 0; i < sb.length(); i++) {
      char ch = sb.charAt(i);
      permutations(sb.deleteCharAt(i), sb2.append(ch), required);
      sb.insert(i, ch);
      sb2.deleteCharAt(sb2.length() - 1);
    }
  }

  public static void main(String[] args) {
    String[] inp = {"2 2 2", "2 2 3"};
    display(gridLand(inp));
  }

  private static void display(String[] gridLand) {
    for (int i = 0; i < gridLand.length; i++) {
      System.out.println(gridLand[i]);
    }

  }
}
