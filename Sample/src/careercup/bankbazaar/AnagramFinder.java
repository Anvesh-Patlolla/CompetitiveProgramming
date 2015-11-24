package careercup.bankbazaar;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Inputs;
import utils.SortString;

public class AnagramFinder {

  HashMap<String, ArrayList<String>> map = null;

  public AnagramFinder(String fileName) {
    traverseDictionary(fileName);
  }

  public void traverseDictionary(String fileName) {
    map = new HashMap<String, ArrayList<String>>();
    Inputs inputUtils = new Inputs();
    ArrayList<String> list = inputUtils.inputFromFile(fileName);
    for (String s : list) {
      String sortString = SortString.sort(s);
      ArrayList<String> mapList = map.get(sortString);
      if (mapList == null) {
        mapList = new ArrayList<String>();
        mapList.add(s);
        map.put(sortString, mapList);
      } else {
        mapList.add(s);
      }
    }
  }

  public void findAnagrams(String name) {
    ArrayList<String> list = map.get(SortString.sort(name));
    for (String s : list) {
      System.out.println(s);
    }
  }

  public static void main(String[] args) {
    String fileName = "C:/Users/anvesh/workspace/Sample/src/careercup/bankbazaar/AnagramFinderInput.txt";
    AnagramFinder finder = new AnagramFinder(fileName);
    String anagram = "apple";
    finder.findAnagrams(anagram);
  }
}
