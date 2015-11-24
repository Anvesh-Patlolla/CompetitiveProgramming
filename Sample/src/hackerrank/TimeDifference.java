package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TimeDifference {

  public static void main(String[] args) {
    TimeDifference obj = new TimeDifference();
    String[] times = {"10:00", "19:20", "06:45", "00:12", "23:50", "04:22"};
    System.out.println(obj.getMinTimeDifference(times));

  }


  static int getMinTimeDifference(String[] times) {
    ArrayList<Pair> list = new ArrayList<Pair>();
    for (String s : times) {
      int hr = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') * 1;
      int min = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0') * 1;
      Pair pair = new Pair(hr, min);
      list.add(pair);
    }
    Collections.sort(list, new Comparator<Pair>() {

      @Override
      public int compare(Pair t1, Pair t2) {
        int hr1 = t1.x;
        int hr2 = t2.x;
        int min1 = t1.y;
        int min2 = t2.y;

        if (hr1 > hr2) {
          return 1;
        } else if (hr2 > hr1) {
          return -1;
        } else {
          if (min1 > min2) {
            return 1;
          } else if (min2 > min1) {
            return -1;
          } else {
            return 0;
          }

        }
      }
    });
    int min = Integer.MAX_VALUE;
    int diff = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      diff = getDiff(list.get(i), list.get(i + 1));
      if (diff < min) {
        min = diff;
      }
    }
    diff = 1440 - getDiff(list.get(0), list.get(list.size() - 1));
    if (diff < min) {
      min = diff;
    }
    return min;
  }

  private static int getDiff2(Pair pair, Pair pair2) {
    // int hr1 =
    return 0;
  }


  private static int getDiff(Pair pair, Pair pair2) {
    int hr1 = pair.x;
    int hr2 = pair2.x;
    int min1 = pair.y;
    int min2 = pair2.y;

    return (hr2 - hr1) * 60 + (min2 - min1);
  }

  static class Pair {
    int x;
    int y;

    Pair(int i, int j) {
      x = i;
      y = j;
    }
  }

}
