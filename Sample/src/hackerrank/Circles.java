package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Circles {

  static int[] Circles(int distance, int[] radius, int[] cost) {
    int maxRadius = Integer.MIN_VALUE;
    int[] retList = new int[radius.length];
    HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
    for (int i = 0; i < radius.length; i++) {
      if (maxRadius < radius[i]) {
        maxRadius = radius[i];
      }
      if (map.containsKey(radius[i])) {
        ArrayList<Pair> li = map.get(radius[i]);
        Pair p = new Pair();
        p.cost = cost[i];
        p.index = i;
        li.add(p);

      } else {
        ArrayList<Pair> li = new ArrayList<>();
        Pair p = new Pair();
        p.cost = cost[i];
        p.index = i;
        li.add(p);
        map.put(radius[i], li);
      }
    }
    for (Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
      ArrayList<Pair> pair = entry.getValue();
      Collections.sort(pair, new Comparator<Pair>() {

        @Override
        public int compare(Pair p1, Pair p2) {
          if (p1.cost > p2.cost) {
            return 1;
          } else if (p1.cost == p2.cost) {
            if (p1.index > p2.index) {
              return 1;
            } else {
              return -1;
            }
          } else {
            return -1;
          }
        }
      });
    }

    int current = 0, previous = maxRadius;
    for (int i = 0; i < radius.length; i++) {
      if (radius[i] + maxRadius < distance) {
        retList[i] = 0;
        previous = i;
      } else {
        if (map.containsKey(radius[i]) == false) {
          retList[i] = 0;
        }

      }
    }

    return retList;
  }

  static class Pair {
    int index;
    int cost;
  }

}
