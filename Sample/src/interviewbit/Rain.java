package interviewbit;

import java.util.List;

public class Rain {
  public int trap(final List<Integer> input) {
    int size = input.size();
    int[] leftArr = new int[size];
    int[] rightArr = new int[size];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < size; i++) {
      max = getMax(max, input.get(i));
      leftArr[i] = max;
    }
    max = Integer.MIN_VALUE;
    for (int i = size - 1; i > -1; i--) {
      max = getMax(max, input.get(i));
      rightArr[i] = max;
    }

    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += getMin(leftArr[i], rightArr[i]) - input.get(i);
    }

    return sum;
  }

  private Integer getMin(int leftArr, int rightArr) {
    return leftArr > rightArr ? rightArr : leftArr;
  }

  private int getMax(int max, int integer) {
    return max > integer ? max : integer;
  }
}
