package vmware;

public class ElementPresentInTree {
	private static int isPresent(Node root, int val) {
		if (root == null) {
			return 0;
		}
		if (root.data == val) {
			return 1;
		}
		if (root.data > val) {
			return isPresent(root.left, val);
		} else {
			return isPresent(root.right, val);
		}

	}

	// For your reference
	class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

}
