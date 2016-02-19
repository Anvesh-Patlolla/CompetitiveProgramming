package hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class HowManyPairs {

  public static void main(String[] args) {
    int N = 0, k = 0;
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    k = sc.nextInt();
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < N; i++) {
      set.add(sc.nextInt());
    }
    System.out.println(calculate(set, k));
  }

  private static int calculate(HashSet<Integer> set, int k) {
    int counter = 0;
    for (int val : set) {
      if ((k % val == 0 && k / val == 2)) {
        continue;
      } else {
        if (set.contains(val - k)) {
          counter++;
        }
      }
    }
    return counter;

  }

}
