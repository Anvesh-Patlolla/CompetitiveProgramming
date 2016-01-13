package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MAXGAP {

  public int maximumGap(final List<Integer> a) {
    if (a.size() < 2) {
      return 0;
    }
    List<Integer> input = new ArrayList<Integer>(a);
    Collections.sort(input);
    int diff = Integer.MIN_VALUE;
    for (int i = 0; i < input.size() - 1; i++) {
      int temp = input.get(i + 1) - input.get(i);
      if (diff < temp) {
        diff = temp;
      }
    }
    return diff;

  }
}
