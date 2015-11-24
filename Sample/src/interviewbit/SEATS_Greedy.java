package interviewbit;

import java.util.ArrayList;
//Solution
public class SEATS_Greedy {
  int mid_r = 0;
  int mid_l = 0;

  public int seats(String a) {
    mid_r = 0;
    mid_l = 0;
    if (a.length() == 0 || a.length() == 1 || a.length() == 2) {
      return 0;
    }

    int sum = 0;
    if (checkTerminalCondition(a)) {
      return 0;
    }
    int mid = (int) getMid2(a);
    mid_l = (int) mid;
    mid_r = (int) mid;
    char[] array = a.toCharArray();
    for (int i = 0; i < a.length(); i++) {
      if (mid - i > -1) {
        sum += calculate(array, mid, mid - i);
      }
      if (mid + i < a.length()) {
        sum += calculate(array, mid, mid + i);
      }
      sum %= 10000003;
    }
    return sum;
  }

  private boolean checkTerminalCondition(String a) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == 'x') {
        count++;
      }
    }
    if (count < 2) {
      return true;
    }
    return false;
  }

  private long getMid(String a) {
    int count = 0;
    long retVal = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == 'x') {
        count++;
        retVal += i;
      }
    }
    return retVal / count;
  }

  private long getMid2(String a) {
    int count = 0;
    long retVal = 0;
    ArrayList<Integer> li = new ArrayList<>();
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == 'x') {
        //
        li.add(i);
      }
    }
    return li.get(li.size() / 2);
  }

  private long calculate(char[] cs, long mid, int index) {
    int i = index;
    if (cs[i] == 'x') {
      cs[i] = '.';

      int temp = (int) mid;

      if (i > mid) {
         temp = mid_r;
        while (temp < cs.length && cs[temp] == 'x') {
          temp++;
        }
        mid_r = temp;
      } else {
         temp = mid_l;
        while (temp > -1 && cs[temp] == 'x') {
          temp--;
        }
        mid_l = temp;
      }

      if (cs[temp] == '.') {
        cs[temp] = 'x';
        // cs[i] = '.';
        //System.out.println(":" + (i - temp));
        return i - temp > 0 ? i - temp : temp - i;
      } else {
        return 0;
      }

    }
    return 0;
  }

  public static void main(String[] args) {
    SEATS_Greedy obj = new SEATS_Greedy();
     String a = "....x..xx...x.."; //5
    // String a = "......xxxx....."; //0
    //String a = "x.x.xx.x.xxx.......x..x.xxx..x.xxx";
    System.out.println(obj.seats(a));
  }
}
