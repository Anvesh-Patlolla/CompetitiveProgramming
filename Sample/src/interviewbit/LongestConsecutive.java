package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutive {
  public int longestConsecutive2(final List<Integer> a) {
    HashSet<Integer> set = new HashSet<>();
    for (Integer i : a) {
      set.add(i);
    }
    int maxSeq = -1;
    for (Integer i : a) {
      int tempMax = 0;
      int nextVal = i + 1;
      while (set.contains(nextVal)) {
        tempMax++;
        nextVal++;
      }
      if (tempMax > maxSeq) {
        maxSeq = tempMax;
      }
    }
    return maxSeq;
  }

  static int max = 0;

  public int longestConsecutive(final List<Integer> a) {
    int max = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    for (Integer i : a) {
      set.add(i);
    }

    for (Integer i : a) {
      int tempMax = 1;
      if (!map.containsKey(i)) {
        tempMax = setMap(map, set, a, i);

        /*
         * int nextVal = i + 1; while (set.contains(nextVal)) {
         * 
         * 
         * nextVal++; tempMax++; }
         */}
      if (tempMax > max) {
        max = tempMax;
      }
    }
    return max;
  }

  private int setMap(HashMap<Integer, Integer> map, HashSet<Integer> set, List<Integer> list,
      Integer val) {
    int retVal = 1;
    if (set.contains(val + 1)) {
      retVal = setMap(map, set, list, val + 1) + 1;
    }
    map.put(val, retVal);
    return retVal;
  }

  public static void main(String[] args) {
    LongestConsecutive obj = new LongestConsecutive();
    List<Integer> list = generateList();
    System.out.println(obj.longestConsecutive3(list));
  }

  private static List<Integer> generateList() {
    int[] array =
        {21, 114, 49, 74, 48, 107, 54, 66, 18, 93, 64, 50, 92, 39, 37, 70, -2, 117, 72, 40, 87, 35,
            79, 52, 44, 4, 38, 84, 25, 113, 106, 32, 27, 57, 68, 45, 96, 36, 108, 17, 86, 2, 118,
            9, 29, 100, 5, 13, 58, 101, 97, 105, 77, 78, 43, 20, 24, 94, 111, 53};
    List<Integer> list = new ArrayList<>();
    // 100, 4, 200, 1, 3, 2
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }
    return list;
  }

  public int longestConsecutive3(final List<Integer> a) {
    int max = 0;
    Set<Integer> set = new HashSet<>();

    for (Integer val : a) {
      set.add(val);
    }
    int count = 0;
    for (Integer val : a) {
      count = 0;
      int l = val - 1;
      int r = val + 1;
      while (set.contains(l)) {

        set.remove(l);
        l--;
        count++;
      }
      while (set.contains(r)) {

        set.remove(r);
        r++;
        count++;
      }
      if (count > max) {
        max = count;
      }
    }


    return max + 1;

  }

}
