package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {

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
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode tail = new ListNode(0);
		ListNode head = tail;
		while (!queue.isEmpty()) {
			ListNode poll = queue.poll();
			tail.next = poll;
			tail = tail.next;
			if (tail.next != null) {
				queue.add(tail.next);
			}
		}
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
