package venky;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/*
 * You may add any imports here, if you wish, but only from the standard library
 */

public class Main {
  public static Map<String, Integer> processData(ArrayList<String> array) {
    /*
     * Modify this method to process `array` as indicated in the question. At the end, return the
     * appropriate value.
     * 
     * Please create appropriate classes, and use appropriate data structures as necessary.
     * 
     * Do not print anything in this method.
     * 
     * Submit this entire program (not just this method) as your answer
     */
    Map<String, Integer> retVal = new HashMap<String, Integer>();
    return retVal;
  }

  public static void main(String[] args) {
    ArrayList<String> inputData = new ArrayList<String>();
    String line;
    try {
      Scanner in = new Scanner(new BufferedReader(new FileReader("C:/Users/anvesh/workspace/Sample/src/venky/input.txt")));
      while (in.hasNextLine())
        inputData.add(in.nextLine());
      Map<String, Integer> retVal = processArray(inputData);
      PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/anvesh/workspace/Sample/src/venky/output.txt")));
      for (Map.Entry<String, Integer> e : retVal.entrySet())
        output.println(e.getKey() + ": " + e.getValue());
      output.close();
    } catch (IOException e) {
      System.out.println("IO error in input.txt or output.txt");
    }
  }

  private static Map<String, Integer> processArray(ArrayList<String> inputData) {
    HashMap<String, Integer> subjectMarks = new HashMap<>();
    HashMap<String, Integer> subjectId = new HashMap<>();
    for (String input : inputData) {
      String token[] = input.split("\\|");
      int id = Integer.parseInt(token[0]);
      int marks = Integer.parseInt(token[2]);
      String subject = token[1];
      if (subjectMarks.containsKey(subject)) {
        int currentMax = subjectMarks.get(subject);
        if (currentMax < marks) {
          subjectId.put(subject, id);
          subjectMarks.put(subject, marks);
        }
      } else {
        subjectMarks.put(subject, marks);
        subjectId.put(subject, id);
      }
    }
    return subjectId;
  }
}
