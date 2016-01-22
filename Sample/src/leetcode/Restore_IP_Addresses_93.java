package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93 {
  List<String> retList = null;

  public List<String> restoreIpAddresses(String s) {
    retList = new ArrayList<String>();
    calculate(s);
    return retList;
  }

  private void calculate(String s) {
    if (s.length() > 12) {
      return;
    }
    for (int i = 1; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        for (int k = j + 1; k < s.length(); k++) {
          String s1 = s.substring(0, i);
          String s2 = (s.substring(i, j));
          String s3 = (s.substring(j, k));
          String s4 = (s.substring(k));

          if (validate(s1) && validate(s2) && validate(s3) && validate(s4)) {
            retList.add(new StringBuilder(s1).append(".").append(s2).append(".").append(s3)
                .append(".").append(s4).toString());
          }
        }
      }
    }
  }

  private boolean validate(String substring) {
    if (substring.length() == 0 || substring.length() > 3 || Integer.parseInt(substring) > 255
        || (substring.charAt(0) == '0' && substring.length() > 1)) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Restore_IP_Addresses_93 obj = new Restore_IP_Addresses_93();
    System.out.println(obj.restoreIpAddresses("25525511135").toString());
    System.out.println(obj.restoreIpAddresses("1231231231234").toString());
  }
}
