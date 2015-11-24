package interviewbit;

import java.util.ArrayList;

public class BULBS_GREEDY {
  public int bulbs(ArrayList<Integer> a) {
    int retVal = 0;
    int count = 0;
    for (int i = 0; i < a.size(); i++) {
      if ((a.get(i) + count) % 2 == 0) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    BULBS_GREEDY obj = new BULBS_GREEDY();
    ArrayList<Integer> a = new ArrayList<>();
    a.add(0);
    a.add(1);
    a.add(0);
    a.add(1);
    System.out.println(obj.bulbs(a));
  }
}
