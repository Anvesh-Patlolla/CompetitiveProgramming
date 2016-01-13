package interviewbit;

import java.util.HashMap;

public class COPYLIST {
  public RandomListNode copyRandomList(RandomListNode head) {
    HashMap<RandomListNode, Integer> originalMap = new HashMap<>();
    HashMap<Integer, RandomListNode> duplicateMap = new HashMap<>();

    RandomListNode head2 = new RandomListNode(0);
    RandomListNode temp2 = head2;
    RandomListNode temp = head;
    int count = 0;

    while (temp != null) {
      originalMap.put(temp, count);
      RandomListNode temp3 = new RandomListNode(temp.label);
      temp2.next = temp3;
      duplicateMap.put(count, temp3);
      temp2 = temp2.next;
      temp = temp.next;
      count++;
    }
    head2 = head2.next;

    temp = head;
    temp2 = head2;
    while (temp != null) {
      int pos = originalMap.get(temp.random) == null ? -1 : originalMap.get(temp.random);

      temp2.random = duplicateMap.get(pos);

      temp = temp.next;
      temp2 = temp2.next;
    }


    return head2;

  }

  class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  };
}
