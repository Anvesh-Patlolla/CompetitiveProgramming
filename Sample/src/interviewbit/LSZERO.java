package interviewbit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LSZERO {
  public ArrayList<Integer> lszero2(ArrayList<Integer> input) {
    int size = input.size();
    // int array[][] = new int[size][size];
    int maxIndexSize = -1;
    int startIndex = -1;
    int endIndex = -1;
    for (int i = 0; i < size; i++) {
      int temp = 0;
      for (int j = i; j < size; j++) {
        if (sum(input, i, j) == 0) {
          if (maxIndexSize < j - i + 1) {
            maxIndexSize = j - i + 1;
            startIndex = i;
            endIndex = j;
          }
        }
      }
    }
    return generateList(input, startIndex, endIndex);
  }

  public ArrayList<Integer> lszero(ArrayList<Integer> input) {
    int size = input.size();
    int sum[] = new int[size];
    int temp = 0;
    LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
    for (int i = 0; i < size; i++) {
      temp = temp + input.get(i);
      sum[i] = temp;
      if (map.containsKey(temp)) {
        ArrayList<Integer> li = map.get(temp);
        li.add(i);
      } else {
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(i);
        map.put(temp, li);
      }
    }
    int maxIndexSize = -1;
    int startIndex = -1, endIndex = -1;
    boolean isZero = false;
    ArrayList<Integer> tempMax = null;
    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      ArrayList<Integer> li = entry.getValue();
      if (li.size() >= 2) {
        int t = li.get(li.size() - 1) - li.get(0);
        if (t > maxIndexSize) {
          maxIndexSize = t;
          tempMax = li;
          isZero = false;
        }
      }
      if (entry.getKey() == 0) {
        int t = li.get(li.size() - 1) + 1;
        if (t > maxIndexSize) {
          maxIndexSize = t;
          tempMax = li;
          isZero = true;
        }
      }
    }
    if (isZero == false) {
      return generateList2(input, tempMax);
    } else {
      return generateList3(input, tempMax);
    }
  }

  private ArrayList<Integer> generateList3(ArrayList<Integer> input, ArrayList<Integer> tempMax) {
    ArrayList<Integer> retList = new ArrayList<>();
    if (tempMax == null) {
      return retList;
    }
    int start = 0;
    int end = tempMax.get(tempMax.size() - 1);
    for (int i = start; i <= end; i++) {
      retList.add(input.get(i));
    }
    return retList;

  }

  private ArrayList<Integer> generateList2(ArrayList<Integer> input, ArrayList<Integer> tempMax) {
    ArrayList<Integer> retList = new ArrayList<>();
    if (tempMax == null) {
      return retList;
    }

    int start = tempMax.get(0) + 1;
    int end = tempMax.get(tempMax.size() - 1);
    for (int i = start; i <= end; i++) {
      retList.add(input.get(i));
    }
    return retList;
  }

  private ArrayList<Integer> generateList(ArrayList<Integer> input, int startIndex, int endIndex) {
    ArrayList<Integer> retlist = new ArrayList<>();
    if (startIndex == -1) {
      return retlist;
    }
    for (int i = startIndex; i <= endIndex; i++) {
      retlist.add(input.get(i));
    }
    return retlist;
  }

  private int sum(ArrayList<Integer> input, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += input.get(i);
    }
    return sum;
  }

  public static void main(String[] args) {
    LSZERO obj = new LSZERO();
    int[] array = {1, 2, -3, 3};
    // int[] array = {1, 2, -2, 4, -4};
    // int[] array = {-19, 8, 2, -8, 19, 5, -2, -23};
    // int[] array = {0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0};
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      input.add(array[i]);
    }
    System.out.println(obj.lszero(input).toString());
  }
}
