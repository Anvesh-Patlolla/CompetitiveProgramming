package leetcode;

public class Delete_Node_in_a_Linked_List_237 {
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
