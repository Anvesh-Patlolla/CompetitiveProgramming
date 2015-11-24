package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class FraudTransactions {

  public static void main(String[] args) {
    String[] transactions =
        {"Shilpa|500|California|63", "Tom|25|New York|615", "Krasi|9000|California|1230",
            "Tom|25|New York|1235", "Tom|25|New York|1238", "Shilpa|50|Michigan|1300",
            "Matt|90000|Georgia|1305", "Jay|100000|Virginia|1310", "Krasi|49|Florida|1320",
            "Krasi|83|California|1325", "Shilpa|50|California|1350"};
    display(getSuspiciousList(transactions));

  }


  private static void display(String[] suspiciousList) {
    for (String s : suspiciousList) {
       System.out.println(s);
    }

  }


  static String[] getSuspiciousList(String[] transactions) {
    HashMap<String, ArrayList<Details>> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    ArrayList<Fraud> retList = new ArrayList<>();
    int appear = 0;
    for (String tuple : transactions) {
      appear++;
      String[] tup = tuple.split("\\|");
      int amount = Integer.parseInt(tup[1]);
      int time = Integer.parseInt(tup[3]);
      Details detail = new Details(tup[2], amount, time, appear);
      String name = tup[0];
      if (amount > 3000) {
        Fraud temp = new Fraud(name, time, appear);
        // if (set.contains(name) == false)
        {
          retList.add(temp);
          set.add(name);
        }
      }
      if (map.get(name) != null) {
        ArrayList<Details> list = map.get(name);
        Details detail2 = list.get(list.size() - 1);
        if (detail.time - detail2.time < 60
            && detail2.location.equalsIgnoreCase(detail.location) == false) {
          Fraud temp = new Fraud(name, detail2.time, detail2.appear);
          // if (set.contains(name) == false)
          {
            retList.add(temp);
            set.add(name);
          }
        }
        list.add(detail);

      } else {
        ArrayList<Details> list = new ArrayList<>();
        list.add(detail);
        map.put(name, list);
      }
    }


    Collections.sort(retList, new Comparator<Fraud>() {

      @Override
      public int compare(Fraud f1, Fraud f2) {
        if (f1.time > f2.time) {
          return 1;
        } else if (f1.time < f2.time) {
          return -1;
        } else {
          if (f1.appear < f2.appear) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    });
    String retString[] = new String[set.size()];
    HashSet<String> temp = new HashSet<>();
    for (int i = 0, j = 0; i < retList.size(); i++) {
      if (temp.contains(retList.get(i).name) == false) {
        retString[j] = retList.get(i).name;
        temp.add(retList.get(i).name);
        j++;
      }
//       System.out.println(retList.get(i).name + " " + retList.get(i).time);
    }
    return retString;
  }

  static class Fraud {
    String name;

    public Fraud(String name, int time, int appear) {
      this.name = name;
      this.time = time;
      this.appear = appear;
    }

    int time;
    int appear;

  }
  static class Details {
    String location;
    int amount;
    int time;
    int appear;

    public Details(String location, int amount, int time, int appear) {
      this.location = location;
      this.amount = amount;
      this.time = time;
      this.appear = appear;
    }
  }
}
