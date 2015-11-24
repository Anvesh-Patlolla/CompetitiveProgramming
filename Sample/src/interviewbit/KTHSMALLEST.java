package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KTHSMALLEST {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int kthsmallest(final List<Integer> input, int k) {

    for (int i = 0; i < input.size(); i++) {
      int count = 1, present = input.get(i);
      for (int j = 0; j < input.size(); j++) {
        if (i != j) {
          if (input.get(j) < input.get(i)) {
            count++;
          }
          if (input.get(i) == input.get(j) && i > j) {
            count++;
          }
        }

      }
      if (count == k) {
        // Collections.sort(input);
        return input.get(i);
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    KTHSMALLEST obj = new KTHSMALLEST();
    int arr[] =
        {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66,
            35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81,
            92};
    List<Integer> input = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      input.add(arr[i]);
    }
    System.out.println(obj.kthsmallest(input, 9));
  }
}
