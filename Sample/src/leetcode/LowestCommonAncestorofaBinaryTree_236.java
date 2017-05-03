package leetcode;

public class LowestCommonAncestorofaBinaryTree_236 {
	
	TreeNode retVal = null;
	boolean left = false, right = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		left = false;
		right = false;
		retVal = null;
		lowestCommonAncestorCalculate(root, p, q);
		return retVal;
	}

	private boolean lowestCommonAncestorCalculate(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}

		boolean left = lowestCommonAncestorCalculate(root.left, p, q);
		boolean right = lowestCommonAncestorCalculate(root.right, p, q);
		boolean isRootANode = (root == p) || (root == q);

		if ((left && right) || (left && isRootANode) || (right && isRootANode)) {
			retVal = root;
		}

		if (root == p || root == q) {
			return true;
		}
		return left || right;
	}

}
