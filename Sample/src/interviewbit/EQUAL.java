package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class EQUAL {
  public ArrayList<Integer> equal2(ArrayList<Integer> input) {
    ArrayList<Integer> retList = new ArrayList<Integer>();
    HashSet<Integer> inputSet = new HashSet<>();
    HashMap<Integer, Integer> eliminatedSet = new HashMap<>();
    int counter = 0;
    for (int i : input) {
      inputSet.add(i);
      eliminatedSet.put(i, counter);
      counter++;
    }
    for (int i = 0; i < input.size(); i++) {
      eliminatedSet.remove(input.get(i));
      for (int j = i + 1; j < input.size(); j++) {
        int sum = input.get(i) + input.get(j);
        for (int k = i + 1; k < input.size(); k++) {
          if (k != j) {
            int C = input.get(k);
            int D = sum - C;
            if (eliminatedSet.containsKey(D)) {
              System.out
                  .println("answer: " + i + "  " + j + "  " + k + "  " + eliminatedSet.get(D));
              retList.add(i);
              retList.add(j);
              retList.add(k);
              retList.add(eliminatedSet.get(D));
              return retList;
            }
          }
        }
      }
    }
    return retList;
  }

  public ArrayList<Integer> equal(ArrayList<Integer> input) {
    LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
    for (int i = 0; i < input.size(); i++) {
      for (int j = i + 1; j < input.size(); j++) {
        int sum = input.get(i) + input.get(j);
        if (map.containsKey(sum)) {
          ArrayList<Integer> li = map.get(sum);
          li.add(i);
          li.add(j);
          System.out.println("In list add");
        } else {
          System.out.println("Adding sum " + sum);
          ArrayList<Integer> li = new ArrayList<>();
          li.add(i);
          li.add(j);
          map.put(sum, li);
        }
      }
    }
    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      ArrayList<Integer> li = entry.getValue();
      if (li.size() >= 4) {
        ArrayList<Integer> retList = generateRetList(li);
        
        System.out.println("Answer: " + retList.toString());
        if(retList.size()==4)
        return retList;
      }
    }
    return new ArrayList<>();
  }

  private ArrayList<Integer> generateRetList(ArrayList<Integer> li) {
    HashSet<Integer> set = new HashSet<Integer>();
    ArrayList<Integer> retList = new ArrayList<>();
    for (int k = 0; k < li.size(); k = k + 2) {
      if (retList.size() == 4) {
        break;
      }
      int i = li.get(k);
      int j = li.get(k + 1);
      if (set.contains(i) == false && set.contains(j) == false) {
        set.add(i);
        set.add(j);
        retList.add(i);
        retList.add(j);
      }
    }
    return retList;
  }

  public static void main(String[] args) {
    EQUAL obj = new EQUAL();
     //int[] array = {1, 1, 1, 1, 1};
    // int[] array = {3, 4, 7, 1, 2, 9, 8};
    //int[] array = {1, 3, 3, 3, 3, 2, 2};
    int[] array = {0, 0, 1, 0, 2, 1 };
    ArrayList<Integer> input = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i++) {
      input.add(array[i]);
    }
    obj.equal(input);
  }
}
