package interviewbit;

import java.util.ArrayList;

public class PERMUTATIONS {
  ArrayList<ArrayList<Integer>> retList = null;

  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> input) {
    retList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> li = new ArrayList<Integer>();
    calculate(input, li);
    return retList;

  }

  private void calculate(ArrayList<Integer> input, ArrayList<Integer> li) {
    if (input.size() == 0) {
      retList.add(li);
      return;
    }
    for (int i = 0; i < input.size(); i++) {
      ArrayList<Integer> temp = new ArrayList<>(input);
      ArrayList<Integer> temp2 = new ArrayList<>(li);
      temp.remove(i);
      temp2.add(input.get(i));
      calculate(temp, temp2);
    }

  }

  public static void main(String[] args) {
    PERMUTATIONS obj = new PERMUTATIONS();
    ArrayList<Integer> input = new ArrayList<Integer>();
    int[] array = {1, 2, 3};
    for (int i = 0; i < array.length; i++) {
      input.add(array[i]);
    }
    System.out.println(obj.permute(input));
  }
}
