package interviewbit;

public class NTHEND {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode removeNthFromEnd(ListNode a, int b) {
    if (a == null || b == 0) {
      return a;
    }
    int length = getListLength(a);
    if (b >= length) {
      ListNode temp = a.next;
      a.next = null;
      return temp;
    }
    ListNode temp1 = a;
    for (int i = 0; i < b; i++) {
      temp1 = temp1.next;
    }
    ListNode temp2 = a;
    while (temp1.next != null) {
      temp1 = temp1.next;
      temp2 = temp2.next;
      System.out.println("temp1: "+temp1.val+ "Temp2 :"+ temp2.val);
      
    }
    ListNode temp3 = temp2.next; 
    temp2 = temp3.next;
    temp3.next = null;
    
    return a;
  }

  private int getListLength(ListNode a) {
    int counter = 0;
    while (a != null) {
      a = a.next;
      counter++;
    }
    return counter;
  }
}
