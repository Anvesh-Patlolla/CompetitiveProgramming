package interviewbit;

import java.util.ArrayList;
import java.util.HashSet;

public class COLORFUL {
  public int colorful(int input) {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (generateList(set, input, list) == false) {
      return 0;
    }
    boolean retVal = calculate(list, set, 2);
    return retVal ? 1 : 0;
  }

  private boolean calculate(ArrayList<Integer> list, HashSet<Integer> set, int size) {
    if (size > list.size()) {
      return true;
    }
    for (int i = 0; i + size <= list.size(); i++) {
      int prod = product(list, i, i + size);
      if (set.contains(prod)) {
        return false;
      } else {
        set.add(prod);
      }
    }

    return calculate(list, set, size + 1);
  }

  private int product(ArrayList<Integer> list, int start, int end) {
    int retVal = 1;
    for (int i = start; i < end; i++) {
      retVal = retVal * list.get(i);
    }
    return retVal;
  }

  private boolean generateList(HashSet<Integer> set, int input, ArrayList<Integer> list) {
    while (input > 0) {
      if (set.contains(input % 10) == false) {
        set.add(input % 10);
        list.add(input % 10);
      } else {
        return false;
      }
      input = input / 10;
    }
    return true;
  }

  public static void main(String[] args) {
    COLORFUL obj = new COLORFUL();
    int input = 123;
    System.out.println(obj.colorful(input));
  }
}
