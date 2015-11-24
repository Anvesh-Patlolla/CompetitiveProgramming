package interviewbit;

import java.util.ArrayList;
import java.util.TreeMap;

public class DNUMS {

  public ArrayList<Integer> dNums(ArrayList<Integer> input, int k) {
    ArrayList<Integer> retList = new ArrayList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    if (k > input.size()) {
      return retList;
    }

    for (int j = 0; j < k; j++) {
      int key = input.get(j);
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }
    for (int i = k; i < input.size(); i++) {
      retList.add(map.size());

      int key = input.get(i - k);
      if (map.get(key) > 1) {
        map.put(key, map.get(key) - 1);
      } else {
        map.remove(key);
      }
      key = input.get(i);
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }
    retList.add(map.size());

    return retList;
  }

  public static void main(String[] args) {
    DNUMS obj = new DNUMS();
    ArrayList<Integer> input = new ArrayList<Integer>();
    int k = 3;
    int arr[] = {1, 2, 1, 3, 4, 3};
    for (int i = 0; i < arr.length; i++) {
      input.add(arr[i]);
    }
    System.out.println(obj.dNums(input, k));
  }
}
