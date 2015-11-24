package interviewbit;

import java.util.HashSet;

public class LISTCYCLE {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode a) {

    HashSet<ListNode> set = new HashSet<>();
    ListNode temp = a;
    while (true) {
      if (temp == null) {
        return null;
      }
      if (set.contains(temp) == false) {
        set.add(temp);
      } else {
        return temp;
      }
      temp = temp.next;


    }
/*
    ListNode joiningNode = getJoiningNode(a);
    if (joiningNode == null) {
      return null;
    }
    int loopLength = getLoopLength(joiningNode);
    if (loopLength == 0) {
      return joiningNode;
    }
    ListNode loopStartingPoint = getLoopStartingPoint(a, loopLength);
    return loopStartingPoint;

*/  }

  private ListNode getLoopStartingPoint(ListNode head, int loopLength) {
    ListNode temp = head;
    for (int i = 0; i < loopLength; i++) {
      temp = temp.next;
    }
    System.out.println("at point A: " + head.val + " point B:" + temp.val);
    while (head != temp) {
      temp = temp.next;
      head = head.next;
    }
    return head;
  }

  private int getLoopLength(ListNode joiningNode) {
    ListNode temp = joiningNode;
    int counter = 0;
    temp = temp.next;
    while (temp != joiningNode) {
      temp = temp.next;
      counter++;
    }
    System.out.println("loop Length " + counter);
    return counter;
  }

  private ListNode getJoiningNode(ListNode a) {
    if (a == null) {
      return null;
    }
    ListNode first = a;
    ListNode second = a;
    while (true) {

      if (first.next == null || second.next == null || second.next.next == null) {
        return null;
      }
      first = first.next;
      second = second.next;
      second = second.next;
      if (first == second) {
        return first;
      }
    }
  }
}
