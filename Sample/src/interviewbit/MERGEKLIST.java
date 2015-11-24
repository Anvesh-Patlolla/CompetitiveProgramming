package interviewbit;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MERGEKLIST {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode mergeKLists(ArrayList<ListNode> input) {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (ListNode li : input) {
      while (li != null) {
        int key = li.val;
        if (map.get(key) != null) {
          map.put(key, map.get(key) + 1);
        } else {
          map.put(key, 1);
        }
        li = li.next;
      }
    }
    ListNode retNode = null;
    ListNode current = null;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

      int key = entry.getKey();
      int val = entry.getValue();
      for (int i = 0; i < val; i++) {
        ListNode temp = new ListNode(key);
        if (retNode == null) {
          retNode = temp;
        } else {
          current.next = temp;
        }
        current = temp;
      }
    }
    return retNode;

  }
}
