package interviewbit;

import java.util.ArrayList;

public class CountInversions {

  public int countInversions(ArrayList<Integer> list) {

    int count = 0;
    int size = list.size();
    for (int i = size - 1; i > -1; i--) {
      for (int j = i - 1; j > -1; j--) {
        if (list.get(j) > list.get(i)) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = getList();
    CountInversions obj = new CountInversions();
    System.out.println(obj.countInversions(list));
  }

  private static ArrayList<Integer> getList() {
    int[] array = {2, 4, 1, 3, 5};
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }

    return list;
  }

}
