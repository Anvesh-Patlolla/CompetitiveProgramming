package vmware;

public class MergeStrings {

	static String mergeStrings(String a, String b) {
		if (a == null && b == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length() || i < b.length(); i++) {
			if (a != null && i < a.length()) {
				sb.append(a.charAt(i));
			}
			if (b != null && i < b.length()) {
				sb.append(b.charAt(i));
			}
		}
		String retString = new String(sb);
		return retString;
	}

	public static void main(String[] args) {
		System.out.println(mergeStrings("abc", "cdefgh"));
	}
}
