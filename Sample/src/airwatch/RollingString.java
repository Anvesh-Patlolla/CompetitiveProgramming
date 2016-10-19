package airwatch;

public class RollingString {
	static String rollingString(String s, String[] operations) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < operations.length; i++) {
			operate(sb, operations[i]);
		}

		return new String(sb);

	}

	private static void operate(StringBuffer sb, String operation) {
		String[] split = operation.split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
		String operator = split[2];
		int temp = 0;
		if (operator.equalsIgnoreCase("L")) {
			temp = -1;
		} else {
			temp = 1;
		}
		for (int i = start; i <= end; i++) {
			int var = sb.charAt(i) - 'a';
			int t1 = (var + temp) % 26;
			if (t1 < 0) {
				t1 += 26;
			}
			char t = (char) ('a' + t1);
			sb.setCharAt(i, t);
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		String[] operations = { "0 0 L", "2 2 L", "0 2 R" };
		System.out.println(rollingString(s, operations));
	}
}
