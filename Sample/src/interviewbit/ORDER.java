package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ORDER {


  public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
    int nH = getNoOfHeights(infronts);
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nH; i++) {
      ArrayList<Integer> li = new ArrayList<>();
      list.add(li);
    }
    for (int i = 0; i < heights.size(); i++) {
      int front = infronts.get(i);
      int height = heights.get(i);
      ArrayList<Integer> li = list.get(front);
      li.add(height);
    }
    for (ArrayList<Integer> li : list) {
      Collections.sort(li);
    }

    ArrayList<Integer> retList = new ArrayList<>();

    int zeroList = 0;
    int index = 0;
    int limit = list.size();
    while (limit != zeroList) {
      ArrayList<Integer> li = list.get(index);
      int val = li.remove(0);
      retList.add(val);
      if (li.size() == 0) {
        list.remove(index);
        index--;
        zeroList++;
      }
      index++;
      if (list.size() == 0) {
        return retList;
      }
      index %= list.size();
    }

    return retList;

  }

  private int getNoOfHeights(ArrayList<Integer> heights) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int h : heights) {
      set.add(h);
    }
    return set.size();
  }

  public static void main(String[] args) {
    ORDER obj = new ORDER();
    ArrayList<Integer> heights = new ArrayList<>();
    ArrayList<Integer> infronts = new ArrayList<>();
    int[] height_array = {5, 3, 2, 6, 1, 4};
    int[] InFronts_array = {0, 1, 2, 0, 3, 2};
    for (int i = 0; i < height_array.length; i++) {
      heights.add(height_array[i]);
      infronts.add(InFronts_array[i]);
    }
    System.out.println(obj.order(heights, infronts));
  }
}
