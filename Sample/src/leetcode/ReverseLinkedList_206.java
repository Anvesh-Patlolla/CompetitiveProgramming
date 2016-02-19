package leetcode;

public class ReverseLinkedList_206 {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList_recursive(ListNode head) {
    if(head == null){
      return head;
  }  
    ListNode retVal = recursiveCalculate(head, null);
    return retVal;
  }

  private ListNode recursiveCalculate(ListNode first, ListNode prev) {
    if (first == null) {
      return prev;
    }
    ListNode retVal = recursiveCalculate(first.next, first);
    first.next = prev;
    return retVal;
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode first = head;
    ListNode second = head.next;
    ListNode third = second.next;
    first.next = null;
    while (third != null) {
      second.next = first;
      first = second;
      second = third;
      third = third.next;
    }

    second.next = first;

    return second;

  }
}
