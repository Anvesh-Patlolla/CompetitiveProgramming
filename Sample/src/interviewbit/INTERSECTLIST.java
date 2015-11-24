package interviewbit;

public class INTERSECTLIST {
  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode a, ListNode b) {
    int l1 = getLength(a);
    int l2 = getLength(b);
    ListNode node = null;
    if (l1 > l2) {
      node = getInter(a, b, l1 - l2);
    } else {
      node = getInter(b, a, l2 - l1);
    }
    return node;
  }

  private ListNode getInter(ListNode a, ListNode b, int i) {
    int count = i;
    while (count != 0) {
      a = a.next;
    }
    while (a != b && a != null && b != null) {
      a = a.next;
      b = b.next;
    }
    if(a == null || b == null){
      return null;
    }
    return a;
  }

  private int getLength(ListNode a) {
    int count = 0;
    while (a != null) {
      count++;
      a = a.next;
    }
    return count;
  }
}
