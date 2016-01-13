package prajeet;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
  public int solution(String input) {
    HashMap<Integer, Integer> numberDurationMap = new HashMap<Integer, Integer>();
    // TreeMap<Integer, Integer> durationNumberMap = new TreeMap<Integer, Integer>();
    for (String s : input.split("\n")) {
      String[] temp = s.split(",");
      String number = temp[1], duration = temp[0];
      int numberInt = getNumber(number);
      int durationInt = getDuration(duration);

      if (numberDurationMap.containsKey(numberInt)) {
        int durationTemp = numberDurationMap.get(numberInt);
        numberDurationMap.put(numberInt, durationTemp + durationInt);
      } else {
        numberDurationMap.put(numberInt, durationInt);
      }

    }
    int max = 0;
    int retVal = 0;
    for (Map.Entry<Integer, Integer> entry : numberDurationMap.entrySet()) {
      int duration = entry.getValue();
      int price = getPrice(duration);
      retVal += price;
      if (price > max) {
        max = price;
      }
    }


    return retVal - max;
  }

  private int getPrice(int duration) {
    if (duration < 300) {
      return duration * 3;
    } else {
      if (duration % 60 == 0) {
        return 150 * (duration / 60);
      } else {
        return 150 * (1 + (duration / 60));
      }
    }
  }

  private int getDuration(String duration) {
    int hrs = (duration.charAt(0) - '0') * 10 + (duration.charAt(1) - '0') * 1;
    int mins = (duration.charAt(3) - '0') * 10 + (duration.charAt(4) - '0') * 1;

    int secs = (duration.charAt(6) - '0') * 10 + (duration.charAt(7) - '0') * 1;
    return hrs * 60 * 60 + mins * 60 + secs;
  }

  private int getNumber(String number) {
    int retval =
        (number.charAt(0) - '0') * 100 + (number.charAt(1) - '0') * 10 + (number.charAt(2) - '0')
            * 1;
    retval =
        retval * 1000 + (number.charAt(4) - '0') * 100 + (number.charAt(5) - '0') * 10
            + (number.charAt(6) - '0') * 1;

    retval =
        retval * 1000 + (number.charAt(8) - '0') * 100 + (number.charAt(9) - '0') * 10
            + (number.charAt(10) - '0') * 1;
    return retval;
  }

  public static void main(String[] args) {
    String s = "00:01:07";
    // System.out.println(s);
    String input = "00:01:00,400-122-121\n00:05:00,701-232-009\n00:05:01,400-122-121";
    System.out.println(new Task1().solution(input));
  }
}
