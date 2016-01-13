package interviewbit;

import java.util.ArrayList;

public class Setzero {
  public void setZeroes(ArrayList<ArrayList<Integer>> input) {
    for (int i = 0; i < input.size(); i++) {
      ArrayList<Integer> list = input.get(i);
      for (int j = 0; j < list.size(); j++) {
        if (input.get(i).get(j) == 0) {
          input.get(i).set(0, 0);
          input.get(0).set(j, 0);
          // setRowZero(input, i, j);
          // setColumnZero(input, i, j);
          break;
        }
      }
    }

    for (int i = 1; i < input.size(); i++) {
      ArrayList<Integer> list = input.get(i);
      if (list.get(0) == 0) {
        for (int j = 0; j < list.size(); j++) {
          list.set(j, 0);
        }
      }
    }

    for (int i = 1; i < input.get(0).size(); i++) {
      if (input.get(0).get(i) == 0) {
        for (int j = 0; j < input.size(); j++) {
          input.get(j).set(i, 0);
        }
      }
    }
  }

  private void setColumnZero(ArrayList<ArrayList<Integer>> input, int i, int j) {

    // if()
    for (int k = 0; k < input.size(); k++) {
      ArrayList<Integer> row = input.get(k);
      if (row.get(j) != 0) {
        row.set(j, 2);
      }
    }

  }

  private void setRowZero(ArrayList<ArrayList<Integer>> input, int i, int j) {
    ArrayList<Integer> row = input.get(i);
    if (j > 0 && row.get(0) == 2 || row.get(0) == 0) {
      return;
    }
    for (int k = 0; k < row.size(); k++) {
      if (row.get(k) != 0) {
        row.set(k, 2);
      }
    }
  }

  public static void main(String[] args) {
    Setzero obj = new Setzero();
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    int arr[][] = { {0, 1}, {1, 1}};
    for (int i = 0; i < arr.length; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < arr[0].length; j++) {
        list.add(arr[i][j]);
      }
      input.add(list);
    }
    obj.setZeroes(input);
  }

}
