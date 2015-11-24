package interviewbit;

import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

public class CANDY_Greedy {
  public int candy(ArrayList<Integer> ratings) {
    int size = ratings.size();
    int left[] = new int[size];
    int right[] = new int[size];
    left[0] = 1;
    right[size - 1] = 1;
    for (int i = 0; i < size; i++) {
      left[i] = 1;
      right[i] = 1;
    }
    for (int i = 1; i < size; i++) {
      if (ratings.get(i) > ratings.get(i - 1)) {
        left[i] = left[i - 1] + 1;
      }
    }
    for (int i = size - 2; i > -1; i--) {
      if (ratings.get(i) > ratings.get(i + 1)) {
        right[i] = right[i + 1] + 1;
      }
    }
    int retVal = 0;
    for (int i = 0; i < size; i++) {
      retVal += max(left[i], right[i]);
    }
    return retVal;
  }

  private int max(int i, int j) {
    return i > j ? i : j;
  }

  public static void main(String[] args) {
    CANDY_Greedy obj = new CANDY_Greedy();
    ArrayList<Integer> ratings = new ArrayList<>();
    ratings.add(1);
    ratings.add(2);
    System.out.println(obj.candy(ratings));
  }
}
