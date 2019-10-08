package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_Two_Sorted_Lists_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null || l2 == null) {
			if (l1 == null) {
				return l2;
			} else {
				return l1;
			}
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(2, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val < o2.val) {
					return -1;
				}
				return 0;
			}
		});
		ListNode temp = new ListNode(0);
		ListNode tail = temp;
		queue.add(l1);
		queue.add(l2);
		while (!queue.isEmpty()) {
			ListNode poll = queue.poll();
			tail.next = poll;
			tail = tail.next;
			if (tail.next != null) {
				queue.add(tail.next);
			}
		}
		return temp.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
