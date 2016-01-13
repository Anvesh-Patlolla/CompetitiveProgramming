package prajeet;

import java.util.ArrayList;
import java.util.HashMap;

public class Task2 {

  int[] retList = null;
  boolean[] checked = null;

  public int[] solution(int[] T) {

    retList = new int[T.length -1];
    checked = new boolean[T.length];
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int capitol = -1;
    for (int i = 0; i < T.length; i++) {
      checked[i] = false;
      if (T[i] == i) {
        capitol = i;
      }
      if (map.containsKey(T[i])) {
        ArrayList<Integer> list = map.get(T[i]);
        list.add(i);
      } else {
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(i);
        map.put(T[i], li);
      }

      if (map.containsKey(i)) {
        ArrayList<Integer> list = map.get(i);
        list.add(T[i]);
      } else {
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(T[i]);
        map.put(i, li);
      }
    }

    dfs(capitol, map, checked, 0);
    return retList;
  }

  private void dfs(int currentNode, HashMap<Integer, ArrayList<Integer>> map, boolean[] checked2,
      int distance) {

    if (distance != 0) {
      retList[distance - 1] += 1;
    }
    checked2[currentNode] = true;
    ArrayList<Integer> li = map.get(currentNode);
    if (li != null) {
      for (int node : li) {
        if (checked2[node] == false) {
          dfs(node, map, checked2, distance + 1);
        }
      }
    }


  }

  public static void main(String[] args) {
    Task2 obj = new Task2();
    int[] T = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};

    display(obj.solution(T));
  }

  private static void display(int[] solution) {
    for (int i = 0; i < solution.length; i++) {
      System.out.println(solution[i]);
    }
  }
}
