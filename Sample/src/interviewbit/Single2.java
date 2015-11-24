package interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Single2 {
  public int singleNumber(final List<Integer> a) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int key : a) {
      if (map.containsKey(key)) {
        int value = map.get(key);
        map.put(key, value + 1);
      } else {
        map.put(key, 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }

  public static void main(String[] args) {

  }

}
