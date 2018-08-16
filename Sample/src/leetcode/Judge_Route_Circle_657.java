package leetcode;

public class Judge_Route_Circle_657 {
	public boolean judgeCircle(String moves) {
		if (moves == null || moves.length() == 0) {
			return true;
		}
		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			}

		}
		if (x == 0 && y == 0) {
			return true;
		}
		return false;
	}
}
