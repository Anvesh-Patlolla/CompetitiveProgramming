package hackerrank.zenefitsCodeSprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Solution
public class MiseryofJarJarBinks {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<String, ArrayList<Character>> map = new HashMap<>();
    int T = sc.nextInt();
    int count = 0;
    sc.nextLine();

    for (int i = 0; i < T; i++) {
      String line = sc.nextLine();

      String[] params = line.split(" ");

      String key = params[0] + params[1] + params[2];
      char val = params[3].charAt(0);
      if (map.containsKey(key)) {
        if (map.get(key).get(0) != val) {
          ArrayList<Character> li = map.get(key);
          li.remove(li.size() - 1);
          if (li.size() == 0) {
            map.remove(key);
          }
          count++;
        } else {
          ArrayList<Character> li = map.get(key);
          li.add(val);
        }
      } else {
        ArrayList<Character> li = new ArrayList<>();
        li.add(val);
        map.put(key, li);
      }
    }
    System.out.println(count);
  }
}
