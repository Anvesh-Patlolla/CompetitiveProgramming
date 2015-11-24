package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SwapArrayNumber {

  static void swap_array(int[] a) {

    ArrayList<Pair> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      int one = getOnes(a[i]);
      Pair p = new Pair();
      p.x = a[i];
      p.y = one;
      list.add(p);
    }
    Collections.sort(list, new Comparator<Pair>() {

      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.y > p2.y) {
          return 1;
        } else if (p2.y > p1.y) {
          return -1;
        } else {
          return p1.x > p2.x ? 1 : -1;
        }
      }
    });

    for (int i = 0; i < list.size(); i++) {
      a[i] = list.get(i).x;
    }
  }

  private static int getOnes(int num) {
    int count = 0;
    while (num != 0) {
      if (num % 2 == 1) {
        count++;
      }
      num = num / 2;
    }
    return count;
  }

  public static class Pair {
    public int x;
    public int y;
  }

  public static void main(String[] args) {
    int[] a = {5, 31, 14, 15, 7, 2};
    swap_array(a);

    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }
}
