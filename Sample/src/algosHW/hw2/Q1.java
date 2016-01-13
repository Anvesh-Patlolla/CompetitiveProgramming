package algosHW.hw2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Q1 {

  private void smallestDenomination(ArrayList<Integer> denomination, int value,
      LinkedHashMap<Integer, Integer> retMap) {
    if (denomination.size() == 0) {
      return;
    }
    int highestDenomination = denomination.get(denomination.size() - 1);
    // get the highest denomination coin
    int numberOfCoins = 0;
    int leftOver = value;
    if (value >= highestDenomination) {
      numberOfCoins = value / highestDenomination;
      leftOver = value % highestDenomination;
      // System.out.println("coins :" + highestDenomination + " no:" + numberOfCoins);
      retMap.put(highestDenomination, numberOfCoins);
    }
    denomination.remove(denomination.size() - 1);
    smallestDenomination(denomination, leftOver, retMap);

    return;// numberOfCoins + recurVal;
  }

  LinkedHashMap<Integer, Integer> smallestDenom(ArrayList<Integer> denomination, int value) {
    Collections.sort(denomination);
    LinkedHashMap<Integer, Integer> retMap = new LinkedHashMap<>();
    smallestDenomination(denomination, value, retMap);
    return retMap;
  }

  public static void main(String[] args) {
    Q1 obj = new Q1();
    ArrayList<Integer> denomination = null;
    denomination = obj.getDenominations();
    int value = 17;
    System.out.println(obj.smallestDenom(denomination, value));
  }

  private ArrayList<Integer> getDenominations() {
    ArrayList<Integer> retList = new ArrayList<>();
    retList.add(50);
    retList.add(25);
    retList.add(10);
    retList.add(5);
    retList.add(1);
    return retList;
  }
}
