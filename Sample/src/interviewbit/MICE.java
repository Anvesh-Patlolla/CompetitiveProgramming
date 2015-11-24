package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class MICE {


  public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
    Collections.sort(a);
    Collections.sort(b);

    int retVal = 0;
    for (int i = 0; i < a.size(); i++) {
      int temp = mod(a.get(i), b.get(i));
      if (temp > retVal) {
        retVal = temp;
      }
    }
    return retVal;
  }

  private int mod(int a, int b) {

    return a - b > 0 ? a - b : b - a;
  }

  public static void main(String[] args) {
    MICE obj = new MICE();
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(4);
    a.add(-4);
    a.add(2);
    ArrayList<Integer> b = new ArrayList<Integer>();
    b.add(4);
    b.add(0);
    b.add(5);
    System.out.println(obj.mice(a, b));
  }
}
