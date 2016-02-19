package hackerrank;

import java.util.HashSet;

public class GoodNodes {

  static int goodNodes(int[] points_to) {

    int length = points_to.length;
    for (int i = 0; i < length; i++) {
      points_to[i]--;
    }
    boolean goodNode[] = new boolean[length];
    goodNode[0] = true;

    int retValCount = 0;
    retValCount = calculate(points_to, goodNode);
    return retValCount;
  }

  private static int calculate(int[] points_to, boolean[] goodNode) {
    int retVal = 0;
    for (int i = 0; i < points_to.length; i++) {
      if (goodNode[i] == false) {
        retVal += traverse(i, points_to, goodNode);
      }
    }
    return retVal;
  }

  private static int traverse(int current, int[] points_to, boolean[] goodNode) {
    HashSet<Integer> set = new HashSet<>();
    while (goodNode[current] == false) {
      set.add(current);
      goodNode[current] = true;
      if (points_to[current] == current) {
        return 1;
      }
      if (set.contains(points_to[current])) {
        return 1;
      }
      current = points_to[current];
    }

    return 0;
  }

  public static void main(String[] args) {
    int[] points_to = {5, 5, 5, 5, 5};
    System.out.println(goodNodes(points_to));
    int[] points_to1 = {1, 1, 2, 3};
    System.out.println(goodNodes(points_to1));
    int[] points_to2 = {1, 2, 3, 4, 5};
    System.out.println(goodNodes(points_to2));
    int[] points_to3 = {4, 6, 1, 2, 8, 7, 6, 1};
    System.out.println(goodNodes(points_to3));
  }
}
