import java.util.ArrayList;
import java.util.Scanner;

public class SnakesAndLadders {

	static ArrayList<Pair> ladders = null;
	static ArrayList<Pair> snakes = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < test; i++) {
            scanner.nextLine();
			String laddersLine = scanner.nextLine();
			String snakesLine = scanner.nextLine();
			parseInputSnakesLadders(laddersLine, snakesLine);
			System.out.println(calculate());
		}

	}

	static int calculate() {
		return calculate(0, ladders, snakes, 0);

	}

	private static int calculate(int current, ArrayList<Pair> ladders,
			ArrayList<Pair> snakes, int hops) {
		if (current == 100) {
			return hops;
		}
		if (100 - current <= 6) {
			return hops + 1;
		}
		int nextLadderIndex =findNearestLadder(current,ladders);
		int nextSnakeIndex = findNearestLadder(current, snakes);
		if(nextLadderIndex == -1)
		{
			return (hops+ (int)Math.ceil((100-current)/6f));
		}
		
		int nextLadder = ladders.get(nextLadderIndex).x;
		int jumpToPoint = ladders.get(nextLadderIndex).y;
		int nextSnakeStart = snakes.get(nextSnakeIndex).y;
		int nextSnakeEndPoint = snakes.get(nextSnakeIndex).y; 
		int hops1 =calculate(jumpToPoint,ladders,snakes,hops+(int)Math.ceil((nextLadder)/6f));
		int hops2 = calculate(nextLadder,ladders,snakes,hops+(int)Math.ceil((nextLadder)/6f));
		//int hop3 = calculate(nextSnakeEndPoint,ladders,snakes,hops+(int)Math.ceil((current-nextSnakeStart)/6f));
		int min =Integer.MAX_VALUE;
		if(hops1< min)
			min =hops1;
		if(hops2< min)
			min =hops1;
		if(hops1< min)
			min =hops1;
		return min;
	}
	
	static int findNearestLadder(int current, ArrayList<Pair> ladders)
	{
		int max =Integer.MAX_VALUE;
		int index =-1;
		for(int i =0;i<ladders.size();i++)
		{
			int lad = ladders.get(i).x;
			
			if(lad > current && max > lad)
			{
				max = lad;
				index = i;
			}
			
		}
		return index;
	}
	

	static void parseInputSnakesLadders(String laddersLine, String snakesLine) {
		ladders = new ArrayList<Pair>();
		snakes = new ArrayList<Pair>();
		int count = 0;
		for (String s : laddersLine.split(" ")) {
			int a = Integer.parseInt(s.substring(0, s.indexOf(",")));
			int b = Integer.parseInt(s.substring(s.indexOf(",") + 1));
			//System.out.println(a + "  " + b);
			ladders.add(new Pair(a, b));

		}
		for (String s : snakesLine.split(" ")) {
			int a = Integer.parseInt(s.substring(0, s.indexOf(",")));
			int b = Integer.parseInt(s.substring(s.indexOf(",") + 1));
			//System.out.println(a + "  " + b);
			snakes.add(new Pair(a, b));

		}
	}

}

class Pair {
	int x,y;
	Pair()
	{
		x =0;y=0;
	}
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

}