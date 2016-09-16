package leetcode;

import java.util.Stack;

public class Google_directory_listing {

	public int solution(String s) {
		String[] split = s.split("\\r?\\n");

		Stack<String> stack = new Stack<>();
		int length = 0;
		int level = -1;
		for (int i = 0; i < split.length; i++) {
			int currentSpaces = getSpaceCount(split[i]);
			if (currentSpaces > level) {
				stack.add(split[i]);
				level = currentSpaces;
			} else {
				for (int k = level; k >= currentSpaces; k--) {
					stack.pop();
				}
				stack.add(split[i]);
				level = currentSpaces;
			}
			if (isFile(split[i]) && isImage(split[i])) {

				length += getLength(stack);
			}
		}
		return length;
	}

	private int getLength(Stack<String> stack) {
		Stack<String> temp = new Stack<>();
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			String d = stack.pop();
			sb.append(d.replace(" ", "")).append('/');
			temp.push(d);
		}
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		return sb.length();
	}

	private int getSpaceCount(String string) {
		int spaces = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' ') {
				return spaces;
			}
			spaces++;
		}
		return spaces;

	}

	boolean isFile(String file) {
		return file.contains(".");
	}

	boolean isImage(String file) {
		return file.contains(".jpeg") || file.contains(".gif") || file.contains(".png");
	}

	public static void main(String[] args) {
		Google_directory_listing ls = new Google_directory_listing();
		System.out
				.println(ls.solution("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif"));
	}
}
