package interviewbit;

import java.util.List;

public class MAXSUM_MSFT {

  public int maxSubArray(final List<Integer> a) {
    int sum = 0;
    int tempSum = 0;
    if (a.size() == 0) {
      return sum;
    }

    for (int i = 0; i < a.size(); i++) {
      tempSum += a.get(i);

      if (tempSum < 0) {
        tempSum = 0;
      }

      if (tempSum > sum) {
        sum = tempSum;
      }
    }
    if (sum == 0) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < a.size(); i++) {
        if (max < a.get(i)) {
          max = a.get(i);
        }
      }
      return max;
    }
    return sum;

  }
}
