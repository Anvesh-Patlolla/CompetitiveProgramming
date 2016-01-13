package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
// import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Circles {

  static int[] Circles(int distance, int[] radius, int[] cost) {
    long maxRadius = Integer.MIN_VALUE;
    long[] retCostList = new long[radius.length];
    long[] retIndexList = new long[radius.length];
    TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
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
    // Iterator it = map.entrySet().iterator();
    for (java.util.Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
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
    ArrayList<RadiusPair> radiusPair = new ArrayList<>();

    for (java.util.Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
      RadiusPair obj = new RadiusPair();
      obj.radius = entry.getKey();
      obj.indexCostList = entry.getValue();
      radiusPair.add(obj);
    }

    // int current = 0, previous = maxRadius;
    HashMap<Integer, Integer> radiusCostMap = new HashMap<Integer, Integer>();
    int last = radiusPair.size() - 1;
    long RadList[] = new long[radius.length];
    for (int i = 0; i < radiusPair.size(); i++) {
      long currentRadius = radiusPair.get(i).radius;
      if (distance > currentRadius + maxRadius) {
        retCostList[i] = Integer.MAX_VALUE;
        radiusCostMap.put((int)currentRadius, (int)0);
      } else {
        long tempMinCost = Integer.MAX_VALUE;
        long tempMinIndex = -1;
        for (int j = last; j > -1 && distance <= currentRadius + radiusPair.get(j).radius; j--, last--) {
          if (tempMinCost > radiusPair.get(j).indexCostList.get(0).cost) {
            tempMinCost = radiusPair.get(j).indexCostList.get(0).cost;
            tempMinIndex = radiusPair.get(j).indexCostList.get(0).index;
          }
        }
        if (i - 1 > -1 && retCostList[i - 1] < tempMinCost) {
          tempMinCost = retCostList[i - 1];
          tempMinIndex = retIndexList[i - 1];
        }
        retCostList[i] = tempMinCost;
        retIndexList[i] = tempMinIndex;
        RadList[i] = currentRadius;
        radiusCostMap.put((int) currentRadius, (int) tempMinIndex +1);
      }
    }

    int finalRetList[] = new int[radius.length];
    for (int i = 0; i < radius.length; i++) {
      int currentRadius = radius[i];/*
                                     * for (int j = 0; j < RadList.length; j++) { if (currentRadius
                                     * == RadList[j]) { finalRetList[i] = (int) retIndexList[j] + 1;
                                     * break; } }
                                     */
      finalRetList[i] = (int) radiusCostMap.get(currentRadius);
    }

    return finalRetList;
  }

  static class Pair {
    long index;
    long cost;
  }

  static class RadiusPair {
    ArrayList<Pair> indexCostList;
    long radius;
  }

  public static void main(String[] args) {
    int distance = 8;
    int[] radius = {1, 3, 6, 2, 5};
    int[] cost = {5, 6, 8, 3, 4};


    // int distance = 1;
    // int[] radius = {4/* , 4, 4, 4, 5, 4, 5 */};
    // int[] cost = {5/* , 4, 3, 2, 2, 2, 2 */};
    display(Circles(distance, radius, cost));
  }

  private static void display(int[] circles) {
    for (int i = 0; i < circles.length; i++) {
      System.out.println(circles[i]);
    }

  }

}
