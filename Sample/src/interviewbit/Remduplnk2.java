package interviewbit;

public class Remduplnk2 {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode deleteDuplicates(ListNode root) {
    if (root.next == null || root == null) {
      return root;
    }

    ListNode dummy = new ListNode(Integer.MAX_VALUE);
    dummy.next = root;

    ListNode temp = root, prev = dummy;
    while (temp != null) {
      boolean flag = false;
      while (temp != null && temp.next != null && temp.val == temp.next.val) {
        temp = temp.next;
        flag = true;
      }
      if (flag) {
        prev.next = temp.next;
        // prev = temp.next;
      } else {
        // prev.next = temp;
        prev = temp;
      }
      if (temp != null) {
        temp = temp.next;
      }
    }
    
    if (dummy.next == null) {
      return null;
    } else {
      return dummy.next;
    }

  }
}
