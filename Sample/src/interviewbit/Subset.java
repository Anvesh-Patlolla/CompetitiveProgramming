package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
  ArrayList<ArrayList<Integer>> retList = null;

  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> input) {
    Collections.sort(input);
    retList = new ArrayList<>();
    retList.add(new ArrayList<Integer>());
    ArrayList<Integer> list = new ArrayList<>();
    calculate(0, list, input);
    return retList;
  }

  private void calculate(int start, ArrayList<Integer> list, ArrayList<Integer> input) {
    if (list.size() != 0) {
      ArrayList<Integer> li = new ArrayList<>(list);
      retList.add(li);
    }
    if (start == input.size()) {
      return;
    }
    for (int i = start; i < input.size(); i++) {
      list.add(input.get(i));
      calculate(i + 1, list, input);
      int size = list.size();
      list.remove(size - 1);
    }

  }

  public static void main(String[] args) {
    Subset obj = new Subset();
    ArrayList<Integer> input = new ArrayList<>();
    int[] array = { 15, 20, 12, 19, 4};
    for (int i = 0; i < array.length; i++) {
      input.add(array[i]);
    }
    System.out.println(obj.subsets(input).toString());
  }
}
