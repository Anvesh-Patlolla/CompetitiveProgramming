package leetcode;

public class FindBottomLeftTreeValue_513 {
	public int findBottomLeftValue(TreeNode root) {
		return findBottomLeftValue(root, 0).value;
	}

	private Pair findBottomLeftValue(TreeNode root, int dept) {
		if (root == null) {
			return new Pair(0, 0);
		}
		if (isLeaf(root)) {
			return new Pair(dept, root.val);
		}
		Pair left = findBottomLeftValue(root.left, dept + 1);
		Pair right = findBottomLeftValue(root.right, dept + 1);
		if (left.dept > right.dept) {
			return left;
		} else if (left.dept < right.dept) {
			return right;
		} else {
			return left;
		}
	}

	private boolean isLeaf(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
	}

	public class Pair {
		int dept;
		int value;

		public Pair(int dept, int value) {
			this.dept = dept;
			this.value = value;
		}
	}
}
