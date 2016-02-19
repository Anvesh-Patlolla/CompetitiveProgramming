package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;

public class StringChain {

  static int longest_chain(String[] words) {
    int longest = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String s : words) {
      map.put(s, 0);
    }
    map.put("", 0);
    int temp = 0;
    for (String s : words) {
      temp = calculate(s, map);
      if (temp > longest) {
        longest = temp;
      }
    }
    return longest;
  }

  private static int calculate(String word, HashMap<String, Integer> map) {
    int retVal = 0;
    LinkedList<Node> bfsQueue = new LinkedList<Node>();
    Node node = new Node(word, 0);
    bfsQueue.add(node);
    while (bfsQueue.isEmpty() == false) {
      Node temp = bfsQueue.pop();
      retVal = temp.distance;
      for (int i = 0; i < temp.word.length(); i++) {
        String s2 = removeChar(temp.word, i);
        if (map.containsKey(s2)) {
          bfsQueue.add(new Node(s2, temp.distance + 1));

        }

      }
    }
    return retVal;
  }

  private static String removeChar(String word, int current) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (i != current) {
        sb.append(word.charAt(i));
      }
    }
    return sb.toString();
  }

  static class Node {
    public Node(String word, int distance) {
      super();
      this.word = word;
      this.distance = distance;
    }

    String word;
    int distance;
  }

  public static void main(String[] args) {
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    System.out.println(longest_chain(words));
  }

}
