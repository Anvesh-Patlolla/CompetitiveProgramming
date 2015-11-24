package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MAXP3_Greedy {

  public int maxp3(ArrayList<Integer> a) {
    if (a.size() < 3) {
      return 0;
    }
//    Comparator<Integer> c = new Comparator<Integer>() {
//      @Override
//      public int compare(Integer val1, Integer val2) {
//        if ((val1) < (val2)) {
//          return -1;
//        } else {
//          return 1;
//        }
//      }
//    };
    Collections.sort(a);
    int size = a.size();
    int temp1 = a.get(size - 1) * a.get(size - 2) * a.get(size - 3);
    int temp2 = a.get(size - 1) * a.get(0) * a.get(1);
    return temp1 > temp2 ? temp1 : temp2;
  }

  public static void main(String[] args) {
    MAXP3_Greedy obj = new MAXP3_Greedy();
    ArrayList<Integer> a = new ArrayList<Integer>();

    obj.maxp3(a);
  }

}
