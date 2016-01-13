package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordLadderII_126 {
  List<List<String>> retList = null;

  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    ArrayList<String> list = new ArrayList<>();
    retList = new ArrayList<List<String>>();
    calculate(beginWord, endWord, wordList, list);
    return retList;

  }

  private void calculate(String beginWord, String endWord, Set<String> wordList,
      ArrayList<String> list) {
    if (beginWord.equals(endWord)) {
      retList.add(list);
      list.remove(list.size() - 1);
      return;
    }
  //  for(int i =0;i<beginWord.)

  }

}
