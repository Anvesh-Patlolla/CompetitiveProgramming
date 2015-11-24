package interviewbit;

import interviewbit.Remduplnk2.ListNode;

public class REMDUPLNK {
  public ListNode deleteDuplicates(ListNode root) {
    if (root == null || root.next == null) {
      return root;
    }

    ListNode temp = root, prev = root;
    while (temp != null) {

      boolean flag = false;
      while (temp != null && temp.next != null && temp.val == temp.next.val) {
        temp = temp.next;
        flag = true;
      }
      if (flag) {
        prev.next = temp;
      }
      prev = temp;
      if (temp != null) {
        temp = temp.next;
      }
    }
    return root;
  }

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
