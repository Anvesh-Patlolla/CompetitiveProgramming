package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {
	public List<String> generateParenthesis(int n) {
		List<String> retList = new ArrayList<>();
		if (n == 0) {
			return retList;
		}
		generate(retList, 0, 0, n, "");
		return retList;

	}

	private void generate(List<String> retList, int open, int close, int n, String currentString) {
		if (open == close && open == n) {
			retList.add(currentString);
		}

		if (open < n) {
			generate(retList, open + 1, close, n, currentString + "(");
		}
		if (open > close) {
			generate(retList, open, close + 1, n, currentString + ")");
		}
	}

	public static void main(String[] args) {
		Generate_Parentheses_22 obj = new Generate_Parentheses_22();
		System.out.println(obj.generateParenthesis(5));
	}
}
