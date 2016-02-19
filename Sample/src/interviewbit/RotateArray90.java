package interviewbit;

import java.util.ArrayList;

public class RotateArray90 {

  public void rotate(ArrayList<ArrayList<Integer>> a) {
    for (int i = 0; i < a.size(); i++) {
      ArrayList<Integer> li = a.get(i);
      for (int j = i; j < li.size(); j++) {
        int temp = li.get(j);
        li.set(j, a.get(li.size() - j - 1).get(i));
        a.get(li.size() - j - 1).set(i, temp);
      }
    }
  }

  public static void main(String[] args) {
    RotateArray90 obj = new RotateArray90();
    ArrayList<ArrayList<Integer>> input = getArray();
    obj.rotate(input);
    System.out.println(input);
  }

  private static ArrayList<ArrayList<Integer>> getArray() {
    int[][] array = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      ArrayList<Integer> li = new ArrayList<Integer>();
      for (int j = 0; j < array[0].length; j++) {
        li.add(array[i][j]);
      }
      retList.add(li);
    }
    return retList;
  }
}
