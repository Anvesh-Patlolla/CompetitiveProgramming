package leetcode;

public class OddEvenLinkedList_328 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode oddEvenList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyFirst = new ListNode(0);
    ListNode dummySecond = new ListNode(0);
    ListNode temp = head;
    ListNode tempFirst = dummyFirst;
    ListNode tempSecond = dummySecond;
    int counter = 0;
    while (temp != null) {
      if (counter % 2 == 0) {
        dummyFirst.next = temp;
        dummyFirst = temp;
      } else {
        dummySecond.next = temp;
        dummySecond = temp;
      }


      counter++;
      temp = temp.next;
    }

    ListNode runner = tempFirst;
    while (runner.next != null) {
      runner = runner.next;
    }
    runner.next = tempSecond.next;

    return tempFirst.next;
  }

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
      odd.next = odd.next.next;// even.next;
      even.next = even.next.next;// odd.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }
}
