package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ANAGRAMS {
  public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
    ConcurrentHashMap<String, ArrayList<Integer>> map = new ConcurrentHashMap<>();
    int counter = 1;
    for (String s : a) {
      char[] ch = s.toCharArray();
      Arrays.sort(ch);
      String s2 = new String(ch);
      if (map.containsKey(s2)) {
        ArrayList<Integer> li = map.get(s2);
        li.add(counter);
      } else {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(counter);
        map.put(s2, li);
      }

      counter++;
    }
    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
    for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
      retList.add(entry.getValue());
    }
    return retList;
  }

}
