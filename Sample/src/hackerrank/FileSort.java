package hackerrank;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class FileSort {


  static ArrayList<String> inputFromKeyboard2() {
    Scanner sc = new Scanner(System.in);
    String s = null;
    ArrayList<String> list = new ArrayList<>();
    int count = 0;
    while ((sc.hasNextLine()) == true/* && count < 2*/) {
      s = sc.nextLine();
      list.add(s);
      // System.out.println("dfghjk -"+s);
      count++;
    }
    return list;


  }

  static ArrayList<String> inputFromKeyboard() {
    InputStreamReader in = null;
    in = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(in);
    String s = null;
    ArrayList<String> list = new ArrayList<>();
    try {
      while ((s = br.readLine()) != null) {
        list.add(s);
      }

    } catch (IOException e) {
      e.printStackTrace();
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return list;
  }


  static ArrayList<String> inputFromFile(String fileName) {

    FileReader in = null;
    try {
      in = new FileReader(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    BufferedReader br = new BufferedReader(in);
    String s = null;
    ArrayList<String> list = new ArrayList<String>();
    try {
      while ((s = br.readLine()) != null) {
        list.add(s);
      }
    } catch (IOException e) {
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    }
    return list;
  }

  public static void main(String[] args) {
    ArrayList<String> inputFiles = inputFromKeyboard2();
    parseFiles(inputFiles);
  }


  private static void parseFiles(ArrayList<String> inputFiles) {
    ArrayList<String> allFilesStrings = new ArrayList<>();
    for (String file : inputFiles) {
      ArrayList<String> fileOutput = getLexographicalFromFile(inputFromFile(file));

      allFilesStrings.addAll(fileOutput);
    }
    // System.out.println(allFilesStrings.toString());

    Collections.sort(allFilesStrings, new Comparator<String>() {

      @Override
      public int compare(String p1, String p2) {
        if (p1.length() < p2.length()) {
          return -1;
        } else if (p1.length() > p2.length()) {
          return 1;
        } else {
          return p1.compareTo(p2);
        }
      }
    });
    // System.out.println("============ RESULT ===========");
    for (String s : allFilesStrings) {
      System.out.println(s);
    }
  }


  private static ArrayList<String> getLexographicalFromFile(ArrayList<String> inputFromFile) {
    ArrayList<String> retVal = new ArrayList<>();
    for (String line : inputFromFile) {
      ArrayList<String> temp = new ArrayList<>();
      for (String s1 : line.split(" ")) {
        temp.add(s1);
      }
      Collections.sort(temp);
      retVal.add(temp.get(0) + temp.get(temp.size() - 1));
    }
    return retVal;
  }
}
