package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GETMODE {
  public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    TreeMap<Integer, Integer> map1 = new TreeMap<>(Collections.reverseOrder());
    int[] array = new int[A.size()];
    for (int i = 0; i < A.size(); i++) {
      int key = A.get(i);
      array[i] = key;
      if (map1.containsKey(key)) {
        int val = map1.get(key);
        map1.put(key, val + 1);
      } else {
        map1.put(key, 1);
      }
    }
    ArrayList<Integer> retList = new ArrayList<Integer>();
    TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    map = generateReverseMap(map1);
    calculate(retList, array, map, B);
    return retList;
  }

  private TreeMap<Integer, Integer> generateReverseMap(TreeMap<Integer, Integer> map1) {
    TreeMap<Integer, Integer> retMap = new TreeMap<>();
    
    for(Map.Entry<Integer, Integer> entry: map1.entrySet()){
      int key = entry.getKey();
      int value = entry.getValue();
      retMap.put(value, key);
    }
    return retMap;
  }

  private void calculate(ArrayList<Integer> retList, int[] array, TreeMap<Integer, Integer> map,
      ArrayList<ArrayList<Integer>> b) {
    for (ArrayList<Integer> update : b) {
      int index = update.get(0);
      int value = update.get(1);
      int decrementValue = array[index - 1];
      int incrementValue = value;
      array[index - 1] = value;
      decrementMap(map, decrementValue);
      incrementMap(map, incrementValue);
      int mode = getMode(map);
      retList.add(mode);
    }

  }

  private int getMode(TreeMap<Integer, Integer> map) {
    int min = Integer.MAX_VALUE;
    int valueMax = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      if (valueMax <= value) {
        valueMax = value;
      }
      if (key < min && value >= valueMax) {
        min = key;
      }

      if (value < valueMax) {
        break;
      }
    }
    System.out.println(min);
    return min;
  }

  private void incrementMap(TreeMap<Integer, Integer> map, int key) {
    if (map.containsKey(key)) {
      int value = map.get(key);
      map.put(key, value + 1);
    } else {
      map.put(key, 1);
    }
  }

  private void decrementMap(TreeMap<Integer, Integer> map, int key) {
    if (map.containsKey(key)) {
      int value = map.get(key);
      map.put(key, value - 1);
    }

  }

  public static void main(String[] args) {
    // A : [ 2, 2, 2, 3, 3 ]
    // B :
    // [2, 2]
    // [3, 3]
    // [3, 3]
    // [2, 1]
    // [4, 3]
    GETMODE obj = new GETMODE();
    int array[] = {3, 2, 1, 1, 3};
    ArrayList<Integer> A = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      A.add(array[i]);
    }

    ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
    
    ArrayList<Integer> temp = new ArrayList<>();
    temp.add(2);
    temp.add(2);
    B.add(temp);
    
    temp = new ArrayList<>();
    temp.add(3);
    temp.add(3);
    B.add(temp);

    temp = new ArrayList<>();
    temp.add(3);
    temp.add(3);
    B.add(temp);

    temp = new ArrayList<>();
    temp.add(2);
    temp.add(1);
    B.add(temp);
    
    temp = new ArrayList<>();
    temp.add(4);
    temp.add(3);
    B.add(temp);

    display(obj.getMode(A, B));
  }

  private static void display(ArrayList<Integer> mode) {
    for(int i:mode){
      System.out.print(i +" ");
    }
  }
}
