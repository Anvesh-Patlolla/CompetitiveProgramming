package interviewbit;

import java.util.ArrayList;

public class SortColors {
  public void sortColors(ArrayList<Integer> a) {
    int zero = 0, one = 0, two = 0;
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) == 0) {
        zero++;
      } else if (a.get(i) == 1) {
        one++;
      } else if (a.get(i) == 2) {
        two++;
      }

    }
    a.clear();
    for (int i = 0; i < zero; i++) {
      a.add(0);
    }
    for (int i = 0; i < one; i++) {
      a.add(1);
    }
    for (int i = 0; i < two; i++) {
      a.add(2);
    }
  }
}
