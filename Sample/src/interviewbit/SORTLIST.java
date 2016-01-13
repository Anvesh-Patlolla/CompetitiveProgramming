package interviewbit;

public class SORTLIST {
  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode sortList(ListNode input) {

    return mergeSort(input);
  }

  private ListNode mergeSort(ListNode input) {
    if (input == null || input.next == null) {
      return input;
    }
    ListNode[] list = splitListNode(input);
    ListNode first = mergeSort(list[0]);
    ListNode second = mergeSort(list[1]);
    ListNode retList = merge2(first, second);
    return retList;
  }

  private ListNode merge(ListNode first, ListNode second) {
    if (first == null) {
      return second;
    } else if (second == null) {
      return first;
    }
    ListNode retVal = null;
    if (first.val > second.val) {
      retVal = second;
      second.next = merge(first, second.next);
    } else {
      retVal = first;
      first.next = merge(first.next, second);
    }

    return retVal;
  }

  private ListNode merge2(ListNode first, ListNode second) {
    if (first == null) {
      return second;
    } else if (second == null) {
      return first;
    }

    ListNode retVal = null;
    if (first.val <= second.val) {
      retVal = first;
    } else {
      retVal = second;
      second = first;
      first = retVal;
    }

    while (first.next != null || second != null) {
      if (first.next.val > second.val) {
        ListNode temp = first.next;
        ListNode temp2 = second.next;

        first.next = second;
        second.next = temp;
        second = temp2;
      } else {
        first = first.next;
      }
    }

    if (first.next == null) {
      first.next = second;
    }

    return retVal;
  }

  private ListNode[] splitListNode(ListNode input) {
    ListNode[] retList = new ListNode[2];
    retList[0] = input;
    if (input == null || input.next == null) {
      retList[1] = null;
      return retList;
    }
    int count = 0;
    ListNode temp = input;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    temp = input;
    for (int i = 0; i < count / 2 - 1; i++) {
      temp = temp.next;
    }

    retList[1] = temp.next;
    temp.next = null;
    return retList;
  }
}
