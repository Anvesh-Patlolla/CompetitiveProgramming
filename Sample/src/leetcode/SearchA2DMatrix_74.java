package leetcode;

public class SearchA2DMatrix_74 {
	public static void main(String[] args) {
		int input[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		SearchA2DMatrix_74 obj = new SearchA2DMatrix_74();
		System.out.println(obj.searchMatrix(input, 10));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int cols = matrix[0].length - 1;
		int rows = matrix.length - 1;
		if (matrix[rows][cols] < target || matrix[0][0] > target) {
			return false;
		}

		for (; rows > -1; rows--) {

			int val = matrix[rows][cols];
			if (matrix[rows][cols] < target) {
				break;
			}
			if (matrix[rows][cols] == target) {
				return true;
			}
		}

		rows++;

		for (; cols > -1; cols--) {
			int val = matrix[rows][cols];
			if (matrix[rows][cols] < target) {
				break;
			}
			if (matrix[rows][cols] == target) {
				return true;
			}
		}

		return false;
	}
}
