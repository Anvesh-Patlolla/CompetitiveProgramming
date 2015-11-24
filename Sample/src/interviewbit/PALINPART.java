package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PALINPART {
  ArrayList<ArrayList<String>> retList = null;

  public ArrayList<ArrayList<String>> partition(String a) {
    retList = new ArrayList<ArrayList<String>>();
    ArrayList<String> li = new ArrayList<String>();
    calculate(a, 0, 0, li);

    return retList;
  }

  private void calculate(String input, int start, int end, ArrayList<String> li) {
    if (end >= input.length()) {
      return;
    } else if (end == input.length() - 1) {
      if (isPalindrome(input, start, end)) {
        // li.add(input.substring(start, end + 1));
        retList.add(li);

      }
    }
    ArrayList<String> li2 = new ArrayList<String>(li);// copyArrayList(li);

    if (isPalindrome(input, start, end)) {
      li.add(input.substring(start, end + 1));
      calculate(input, end + 1, end + 1, li);
    }
    calculate(input, start, end + 1, li2);

  }

  private ArrayList<String> copyArrayList(ArrayList<String> li) {
    ArrayList<String> retList = new ArrayList<String>();
    for (String s : li) {
      retList.add(s);
    }
    return retList;
  }

  private boolean isPalindrome(String input, int startPoint, int endPoint) {
    int counter = (endPoint - startPoint) / 2 + 1;
    for (int i = 0; i < counter; startPoint++, endPoint--, i++) {
      if (input.charAt(startPoint) != input.charAt(endPoint)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    PALINPART obj = new PALINPART();
    String sample = "aab";
    // System.out.println(obj.isPalindrome(sample, 1, sample.length() - 2));

    obj.partition(sample);
    obj.display();
  }

  private void display() {
    for (ArrayList<String> li : retList) {
      for (String s : li) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  public int repeatedNumber2(final List<Integer> a) {
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    for (int i : a) {
      if (map.containsKey(i)) {
        return i;
      } else {
        map.put(i, true);
      }
    }
    return 0;
  }

  // DO NOT MODIFY THE LIST
  public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
    HashSet<Integer> set = new HashSet<>();
    int A = -1;
    int count = 0;
    for (int i : a) {
      count += i;
      if (set.contains(i)) {
        A = i;
      }
      set.add(i);
    }
    int B = 0;
    for (int k = 1; k <= a.size(); k++) {
      if(set.contains(k) == false)
      {
        B = k; break;
      }
    }/*
    int n = a.size();
    long temp = n * (n + 1);
    temp = temp / 2;
    count = count - A;
    B = (int) temp - count;*/
    ArrayList<Integer> retList = new ArrayList<Integer>();
    retList.add(A);
    retList.add(B);
    return retList;
  }
}
