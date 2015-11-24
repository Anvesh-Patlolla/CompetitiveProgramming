package interviewbit;

import java.util.ArrayList;

public class Substract {
  public ListNode subtract(ListNode a) {
    int length = getLength(a);
    ArrayList<Integer> list = getList(a);
    ListNode temp = a;
    for (int i = 0; i < list.size(); i++) {
      temp.val = list.get(list.size() - i - 1) - temp.val;
      temp = temp.next;
    }
    return a;
    
  }

  private ArrayList<Integer> getList(ListNode node) {
    ArrayList<Integer> list = new ArrayList<>();

    while (node != null) {
      list.add(node.val);
    }
    return list;
  }

  private void substract(ListNode start, ListNode last, ListNode first, int length, int current) {
    // last node
    if (last.next == null) {
      start.val = last.val - start.val;

      System.out.println("DEBUG - last node, first node val " + start.val);
      return;
    }
    if (start == last && last != first) {
      return;
    }
    substract(start, last.next, first, length, current + 1);
    if (current < length / 2) {
      return;
    }
    ListNode nextNode = start.next;
    for (int i = length - current; i < length; i++) {
      nextNode = nextNode.next;
    }
    nextNode.val = last.val - nextNode.val;

    System.out.println("DEBUG - other node, first node val " + nextNode.val);

  }

  private int getLength(ListNode node) {
    int count = 0;
    while (node != null) {
      node = node.next;
      count++;
    }
    return count;
  }


  // Definition for singly-linked list.
  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
