package leetcode;

public class CountCompleteTreeNodes_222 {
	int count = 0;

	public int countNodes(TreeNode root) {
		count = 0;
		countNodes_calculate(root);
		return count;
	}

	private void countNodes_calculate(TreeNode root) {
		if (root == null) {
			return;
		}
		countNodes_calculate(root.left);
		count++;
		countNodes_calculate(root.right);
	}
}
