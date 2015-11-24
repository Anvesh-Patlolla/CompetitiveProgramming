package interviewbit;

import java.util.ArrayList;

public class MAXONE {

  public ArrayList<Integer> maxone(ArrayList<Integer> input, int M) {
    int max = 0, tempMax = 0;
    int startIndex = 0, endIndex = 0;
    int oneSum = 0;
    for (int i = 0; i < input.size(); i++) {
      if (input.get(i) == 0) {
        int j = i;
        for (int m = M; j < input.size() && m > 0; j++) {
          if (input.get(j) == 1) {
            oneSum++;
            continue;
          } else {
            oneSum++;
            m--;
          }
        }
        boolean flag = true;
        int k = 0;
        for (k = j; k < input.size() && flag; k++) {
          if (input.get(k) == 1) {
            oneSum++;
          } else {
            flag = false;
          }
        }

        if (oneSum > max) {
          max = oneSum;
          startIndex = i;
          endIndex = k;
        }
        oneSum = 0;
        startIndex = i + 1;
      } else {
        oneSum++;
      }
    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int l = startIndex; l <= endIndex; l++) {
      list.add(l);
    }
    return list;
  }

  public static void main(String[] args) {
    // Array = {1 1 0 1 1 0 0 1 1 1 }
    // M = 1
    MAXONE obj = new MAXONE();
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(1);
    input.add(0);
    input.add(1);
    input.add(1);
    input.add(0);
    input.add(0);
    input.add(1);
    input.add(1);
    input.add(1);
    System.out.println(obj.maxone(input, 1));
  }
}
