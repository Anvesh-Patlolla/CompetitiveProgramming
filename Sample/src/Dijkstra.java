import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dijkstra {

	static int[] distance;
	static int[] previous;
	static int[][] graph;
	static int v = 0;
	static int nodes[];

	public static void main(String[] args) {
		v = Integer.parseInt(getInputFromKeyboard());
		distance = new int[v];
		previous = new int[v];
		graph = new int[v][v];

		for (int i = 0; i < v; i++) {
			// get the input for graph
		}
		for (int i = 0; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
			previous[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;

		nodes = new int[v];
		for (int i = 0; i < v; i++) {
			nodes[i] = i;
		}
		while (!isNodesEmpty()) {
			int u = getMin();
			nodes[u] = -1;
			for(int i=0;i<v;i++)
			{
				//calculate the u+v http://en.wikipedia.org/wiki/Dijkstra's_algorithm
			}
		}

	}

	static boolean isNodesEmpty() {
		for (int i = 0; i < v; i++) {
			if (nodes[i] != -1)
				return false;
		}
		return true;
	}

	static int getMin() {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < v; i++) {
			if (distance[i] < min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}

	static String getInputFromKeyboard() {
		String s = null;
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			s = bufferRead.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return s;

	}
}
