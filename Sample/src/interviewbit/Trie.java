package interviewbit;

import java.util.ArrayList;

public class Trie {
  Trie[] nodes;
  char val;
  int count = 0;

  Trie insert(char[] ch) {
    Trie temp = this;

    for (int i = 0; i < ch.length; i++) {

      if (temp.nodes == null) {
        temp.nodes = new Trie[26];
      }
      if (temp.nodes[ch[i] - 'a'] == null) {
        temp.nodes[ch[i] - 'a'] = new Trie();
        temp.count++;
      }
      temp = temp.nodes[ch[i] - 'a'];
      temp.val = ch[i];

    }
    return this;
  }

  public Trie() {

  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    ArrayList<String> input = new ArrayList<String>();
    input.add("zebra");
    input.add("dog");
    input.add("duck");
    input.add("dove");
    trie.prefix(input);
  }

  ArrayList<String> retList = null;

  public ArrayList<String> prefix(ArrayList<String> input) {
    Trie trie = new Trie();
    for (String s : input) {
      trie.insert(s.toCharArray());
    }

    retList = new ArrayList<>();
    calculate(trie);
    return retList;
  }

  private void calculate(Trie trie) {
    for (int i = 0; i < 26; i++) {
      if (trie.nodes[i] != null) {
        calculate(trie.nodes[i], "");
      }
    }

  }

  private void calculate(Trie trie, String string) {
    if (trie == null) {
      return;
    }
    if (trie.count < 2) {
      retList.add(string + trie.val);
      return;
    }
    for (int i = 0; i < 26; i++) {
      if (trie.nodes[i] != null) {
        calculate(trie.nodes[i], string + trie.val);
      }
    }

  }
}
