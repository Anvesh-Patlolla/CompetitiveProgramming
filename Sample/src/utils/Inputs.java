package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Inputs {

  public String inputFromKeyboard() {
    InputStreamReader in = null;
    in = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(in);
    String s = null;
    try {
      s = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      try {
        br.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return s;
  }

  public ArrayList<String> inputFromFile(String fileName) {

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

  void writeToFile(String fileLocation) {
    try {

      String content = "This is the content to write into file";

      File file = new File(fileLocation);

      // if file doesnt exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();

      System.out.println("Done");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
