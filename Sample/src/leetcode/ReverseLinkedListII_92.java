package leetcode;


public class ReverseLinkedListII_92 {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) {
      return head;
    }
    
    return head;
  }


  public ListNode reverseList(ListNode head, ListNode last) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode first = head;
    ListNode second = head.next;
    ListNode third = second.next;
    first.next = last.next;
    while (third != last) {
      second.next = first;
      first = second;
      second = third;
      third = third.next;
    }

    second.next = first;

    return second;

  }

}
