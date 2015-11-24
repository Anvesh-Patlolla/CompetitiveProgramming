package hackerrank;

import java.util.ArrayList;
import java.util.Collections;

public class TruthLair {

  public static void main(String[] args) {
    TruthLair obj = new TruthLair();
    // String[] relation1 = {"ankur","debasis","rohit","nirdosh","aakash"};
    // String[] relation2 = {"karthik","karthik","karthik","karthik","karthik"};/*{"sita", "sita",
    // "sita", "george", "bikash", "mukul"}*/;
    String[] relation1 = {"ram", "george", "karthik", "ravi", "karthik", "bikash"};
    String[] relation2 = {"sita", "sita", "sita", "george", "bikash", "mukul"};
    String liar = "karthik";
    boolean islair = true;
    // obj.identify(relation1, relation2, liar, islair);
    // obj.display();
    String[] relation =
        {"ram,sita", "george,sita", "karthik,sita", "ravi,george", "karthik,bikash", "bikash,mukul"};
    obj.identify(relation, liar);
  }


  private String[] display() {

    Collections.sort(liars);
    for (String l : liars) {
       //System.out.println("lair - " + l);
    }
    String[] ret = new String[liars.size()];
    int i = 0;
    for (String lis : liars) {
      ret[i] = lis;
      i++;
    }
    return ret;
    /*
     * for (String l : truths) { System.out.println("truths - " + l); }
     */
  }

  ArrayList<String> liars = new ArrayList<String>();
  ArrayList<String> truths = new ArrayList<String>();

  String[] identify(String[] relations, String liar) {
    int length = relations.length;
    String relation1[] = new String[length];
    String relation2[] = new String[length];

    int i = 0;
    for (String li : relations) {
      String s[] = li.split(",");
      {
        relation1[i] = s[0];
        relation2[i] = s[1];
      }
      i++;
    }
    identify(relation1, relation2, liar, true);
    return display();
  }

  String[] identify(String[] relation1, String[] relation2, String liar, boolean islair) {
    // int total = relations.length;
    if (islair) {
      ArrayList<String> list = getCounter(liar, relation1, relation2); // list of truths.
      for (String l : list) {
        truths.add(l);
        identify(relation1, relation2, l, false);
      }
    } else {
      ArrayList<String> list = getCounter(liar, relation1, relation2);
      for (String l : list) {
        liars.add(l);
        identify(relation1, relation2, l, true);
      }
    }

    return null;

  }

  private ArrayList<String> getCounter(String lair, String[] relation1, String[] relation2) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < relation1.length; i++) {
      if (relation1[i].equals(lair)) {
        if (liars.contains(relation2[i]) == false && truths.contains(relation2[i]) == false) {
          list.add(relation2[i]);
        }
      }
    }
    for (int i = 0; i < relation2.length; i++) {
      String l = relation2[i];
      String r = relation1[i];
      if (l.equals(lair)) {
        if (liars.contains(r) == false && truths.contains(r) == false) {
          list.add(r);
        }
      }
    }
    return list;

  }
}
