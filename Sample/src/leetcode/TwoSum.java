package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] ret = new int[2];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();
      if (map.containsKey(target - key)) {
        int r1 = map.get(target - key);
        int r2 = map.get(key);
        if (r1 > r2) {
          ret[0] = r2 + 1;
          ret[1] = r1 + 1;
        } else {
          ret[1] = r2 + 1;
          ret[0] = r1 + 1;

        }
        return ret;
      }
    }


    return ret;
  }
}
