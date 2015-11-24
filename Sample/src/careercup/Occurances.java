package careercup;

import java.awt.Point;
import java.util.ArrayList;

/*
 * 
 How many occurrences of a given search word can you find in a two-dimensional array of characters given that the word can go up, down, left, right, and around 90 degree bends? 

 Ex: 
 Count of occurrences of SNAKES 
 S N B S N 
 B A K E A 
 B K B B K 
 S E B S E 

 The answer is 3. 

 */

public class Occurances {

	static String[] list = { "SNBSN", "BAKEA", "BKBBK", "SEBSE" };
	static String compare = "SNAKES";

	// String[] errorSoon = {"Hello", "World"};
	public static void main(String[] args) {
		calculate();
	}

	private static void calculate() {
		System.out.println(calculate(0, 0, 0, null, null));
	}

	private static int calculate(int i, int j, int ind, String string,
			ArrayList<Point> points) {
		//if()
		/*StringBuffer tempString = new StringBuffer(string);
		ArrayList<Point> tempList =new ArrayList<Point>(points);
        */
		
		if (list[i].charAt(j) == compare.charAt(ind)) {
			if (points == null && ind == 0) {
				points = new ArrayList<>();
				string = new String();
			}
			//points.add(new Point(i, j));
			string+=compare.charAt(ind);
			ind++;

		}
		if (ind >= compare.length()) {
			//display(points);
			System.out.println(string);
			return 1;

		}
		//new ArrayList<Point>(points);

		int temp =0;
		if (i + 1 < 4 && list[i + 1].charAt(j) == compare.charAt(ind)) {
			temp+=calculate(i + 1, j, ind, string, points);
			
		}
		
		if (i - 1 > -1  && list[i - 1].charAt(j) == compare.charAt(ind)) {
			temp+=calculate(i - 1, j, ind, string, points);
			
		}
		if (j + 1 < 5 && list[i].charAt(j + 1) == compare.charAt(ind)) {
			temp+=calculate(i, j + 1, ind , string, points);
		}
		if (j - 1 > -1 && list[i].charAt(j - 1) == compare.charAt(ind)) {
			temp+=calculate(i, j - 1, ind, string, points);
		}
		return temp;
	}

	private static void display(ArrayList<Point> points) {
		// if(points == null) return;
		System.out.println("-------------Here  starts ------------");
		for (int i = 0; i < points.size(); i++) {
			System.out.println(points.get(i).x + "  " + points.get(i).y);
		}
		System.out.println("-------------Here  Ends ------------");
		

	}
}
