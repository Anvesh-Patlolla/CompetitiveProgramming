package interviewbit;

import java.awt.Robot;

public class Partitionlist {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode partition(ListNode head, int key) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode temp1 = head.next;
    ListNode temp2 = head;
    int counter1 = 0;
    while (temp1 != null) {
      // System.out.println("in first iteration: " + temp1.val);
      temp2 = temp1;
      temp1 = temp1.next;
      counter1++;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tailPointer = temp2;
    temp1 = head;
    temp2 = dummy;
    int counter2 = 0;
    while (temp1 != null && counter1 >= counter2 && temp1 != tailPointer) {

      // System.out.println("in second iteration: " + temp1.val);
      if (temp1.val >= key) {

        temp2.next = temp1.next;
        tailPointer = addToTail(tailPointer, temp1);
        temp1 = temp2.next;
      } else {
        temp2 = temp1;
        temp1 = temp1.next;
      }
      counter2++;
    }
    return dummy.next;
  }

  private ListNode addToTail(ListNode tailPointer, ListNode temp1) {
    tailPointer.next = temp1;
    temp1.next = null;
    return temp1;
  }

  void insert(int val) {
    ListNode node = new ListNode(val);

    if (root == null) {
      root = node;
    } else {
      ListNode temp = root;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }
  }

  ListNode root = null;

  public static void main(String[] args) {
    Partitionlist obj = new Partitionlist();
    /*
     * int arr[] = {18, 595, 253, 7, 984, 914, 903, 992, 522, 784, 55, 910, 123, 133, 936, 38, 774,
     * 868, 204, 727, 927, 981, 766, 619, 848, 398, 782, 460, 444, 805, 62, 154, 35, 261, 202, 622,
     * 472, 151, 590, 270, 115, 773, 332, 928, 298, 597, 150, 704, 229, 205, 501, 284, 497, 305,
     * 864, 368, 995, 731, 255, 712, 614, 179, 756, 432, 415, 734, 449, 85, 817, 686, 829, 12, 564,
     * 427, 711, 275, 109, 641, 344, 934, 760, 551, 958, 540, 446};
     */
    int arr[] = {1, 2, 3, 4, 5};
    for (int i = 0; i < arr.length; i++) {
      obj.insert(arr[i]);
    }
    obj.display(obj.root);
    ListNode temp = obj.partition(obj.root, 5);
    obj.display(temp);
  }

  private void display(ListNode root2) {
    while (root2 != null) {
      System.out.println("d " + root2.val);
      root2 = root2.next;
    }
  }


}
