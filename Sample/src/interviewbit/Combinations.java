package interviewbit;

import java.util.ArrayList;

public class Combinations {
  ArrayList<ArrayList<Integer>> retList = null;

  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    retList = new ArrayList<>();
    // if (n == k) {
    // ArrayList<Integer> list = new ArrayList<>();
    // for (int e = 1; e <= n; e++) {
    // list.add(e);
    // }
    // retList.add(list);
    // return retList;
    // }
    // for (int startNumber = 1; startNumber <= n - k + 1; startNumber++) {
    ArrayList<Integer> list = new ArrayList<>();
    calculate(1, n, k, list);
    // }
    return retList;
  }

  private void calculate(int startNumber, int n, int k, ArrayList<Integer> list) {

    if (k == list.size()) {
      ArrayList<Integer> ret = new ArrayList<>(list);
      retList.add(ret);
      return;
    }
    for (int i = startNumber, j = 0; j < n && i <= n; j++, i++) {
      list.add(i);
      calculate(i + 1, n, k, list);
      int size = list.size();
      list.remove(size - 1);
    }

    return;
  }

  public static void main(String[] args) {
    Combinations obj = new Combinations();
    System.out.println(obj.combine(1, 1).toString());
  }
}
