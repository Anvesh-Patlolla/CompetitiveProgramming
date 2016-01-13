package venky.knowlarity;

import java.util.HashSet;
import java.util.Scanner;

// Solution
public class KDiff {


  public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int count = 0;
    HashSet<Integer> h = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      h.add(x);
      if (h.contains(x - k)) {
        count++;
      }

      if (h.contains(x + k)) {
        count++;
      }
    }
    System.out.println(count);
  }



}
