package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class SUM3 {
  public int threeSumClosest2(ArrayList<Integer> input, int target) {
    int minMod = Integer.MAX_VALUE;
    int retVal = -1;
    boolean negative = false;
    for (int i = 0; i < input.size() - 1; i++) {
      int temp1 = input.get(i);

      for (int j = i + 2; j < input.size(); j++) {
        int temp2 = input.get(j - 1);
        if (mod(target - temp1 - temp2 - input.get(j)) < minMod) {
          // index =-1;
          retVal = temp1 + temp2 + input.get(j);
          minMod = mod(target - temp1 - temp2 - input.get(j));
        }
      }
    }
    return retVal;

  }

  public int threeSumClosest(ArrayList<Integer> input, int target) {
    Collections.sort(input);
    int diff = Integer.MAX_VALUE, temp = Integer.MAX_VALUE;
    int retVal = Integer.MAX_VALUE;
    int size = input.size();
    for (int i = 0; i < input.size(); i++) {
      int first = (i);
      int second = i + 1;
      int third = (size - 1);
      while (second < third) {
        int sum = input.get(first) + input.get(second) + input.get(third);
        if (sum > target) {
          third--;
        } else {
          second++;
        }
        temp = mod(sum - target);
        if (temp < diff) {
          diff = temp;
          retVal = sum;
        }
        if (diff == 0) {
          return retVal;
        }
      }
    }
    return retVal;

  }

  private int mod(int i) {

    return i > 0 ? i : -1 * i;
  }

  public static void main(String[] args) {
    SUM3 obj = new SUM3();

    ArrayList<Integer> input = new ArrayList<>();
    // int array[] = {5, -2, -1, -10, 10};
    // int array[] = {-4, -8, -10, -9, -1, 1, -2, 0, -8, -2};
//    int array[] =
//        {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0,
//            -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0,
//            -4, -3, 1, 6, -3};

    int array[] = {9, -3, -7, 5, 2, -6, 3, -9, -10, 5, -2, -5, 5, 2, -7, 6, -4, -7, -9, -7, -8, -6, 6, 7, 8, -6, 2, -10, -6, -1, -4, -1, 1, 5, -4, -9, -10, 2, -10, 4, -3, 4, 10, 2, 3};
    for (int i = 0; i < array.length; i++) {
      input.add(array[i]);
    }

    int target = -2;
    System.out.println(obj.threeSumClosest(input, target));
  }
}
