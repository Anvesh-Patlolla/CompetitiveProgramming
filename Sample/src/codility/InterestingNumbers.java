package codility;

import java.util.HashSet;

public class InterestingNumbers {

  public int solution(String S, String T) {
    String t1[] = S.split(":");
    String t2[] = T.split(":");

    int hr1 = Integer.parseInt(t1[0]), min1 = Integer.parseInt(t1[1]), sec1 =
        Integer.parseInt(t1[2]);
    int hr2 = Integer.parseInt(t2[0]), min2 = Integer.parseInt(t2[1]), sec2 =
        Integer.parseInt(t2[2]);
    int count = 0;
    if (interestingNumber(hr1, min1, sec1)) {
      count++;
    }
    while ((hr1 != hr2) || (min1 != min2) || (sec1 != sec2)) {

      sec1++;

      if (sec1 >= 60) {
        min1++;
        sec1 %= 60;
      }
      if (min1 >= 60) {
        hr1++;
        min1 %= 60;
      }
      if (interestingNumber(hr1, min1, sec1)) {
        count++;
      }

    }
    if (interestingNumber(hr2, min2, sec2)) {
      // count++;
    }


    return count;
  }

  private boolean interestingNumber(int hr, int min, int sec) {
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(hr % 10);
    set.add(hr / 10);
    set.add(min % 10);
    set.add(min / 10);
    set.add(sec % 10);
    set.add(sec / 10);

    return set.size() < 3 ? true : false;
  }

  public static void main(String[] args) {
    InterestingNumbers obj = new InterestingNumbers();
    System.out.println(obj.solution("15:15:00", "15:15:12"));
    // '22:22:21', '22:22:23'
    System.out.println(obj.solution("22:22:21", "22:22:23"));

    System.out.println(obj.solution("00:00:00", "23:59:59"));
    System.out.println(obj.solution("12:21:00", "14:18:37"));
    System.out.println(obj.solution("15:15:15", "15:15:15"));

  }
}
