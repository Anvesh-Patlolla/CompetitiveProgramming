package ai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SearchRomania {
	private static String FILE_LOCATION = "/Users/anvesh/git/CompetitiveProgramming/Sample/src/ai/H1Q5_input";
	private HashMap<String, ArrayList<String>> adjList;

	// java SearchRomania searchtype srccityname destcityname
	public static void main(String[] args) {
		String searchType = args[0];
		String source = args[1].toLowerCase();
		String destination = args[2].toLowerCase();
		
		if (searchType.equalsIgnoreCase("DFS")) {
			SearchRomania obj = new SearchRomania();
			obj.dfs(source, destination);
		} else {
			SearchRomania obj = new SearchRomania();
			obj.bfs(source, destination);
		}

		// SearchRomania obj = new SearchRomania();
		// obj.dfs(source, destination);
		// SearchRomania obj2 = new SearchRomania();
		// obj2.bfs(source, destination);
		//
		// SearchRomania obj3 = new SearchRomania();
		// obj3.dfs(destination, source);
		// SearchRomania obj4 = new SearchRomania();
		// obj4.bfs(destination, source);

	}

	private void bfs(String source, String destination) {
		adjList = inputFromFile(FILE_LOCATION);
		sortAdjListAlphabetically(adjList);
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> orderOfVisit = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			String current = queue.remove();

			if (!visited.contains(current)) {
				orderOfVisit.add(current);
			}
			visited.add(current);
			ArrayList<String> list = adjList.get(current);
			if (list == null) {
				break;
			}
			for (int i = 0; i < list.size(); i++) {
				String temp = list.get(i);
				if (!visited.contains(temp)) {
					queue.add(temp);
				}
			}
		}
		System.out.println("BFS: from " + source + " to " + destination);
		displayOrderOfVisitedNodes(orderOfVisit, destination);
	}

	private void displayOrderOfVisitedNodes(ArrayList<String> orderOfVisit, String destination) {
		for (int i = 0; i < orderOfVisit.size(); i++) {
			System.out.print(orderOfVisit.get(i) + " -");
			if (orderOfVisit.get(i).equalsIgnoreCase(destination)) {
				System.out.println();
				return;
			}
		}

	}

	private void dfs(String source, String destination) {
		adjList = inputFromFile(FILE_LOCATION);
		sortAdjListAlphabetically(adjList);
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> orderOfVisit = new ArrayList<>();
		String currentNode = source;
		dfs(currentNode, adjList, visited, orderOfVisit);

		System.out.println("DFS: from " + source + " to " + destination);
		displayOrderOfVisitedNodes(orderOfVisit, destination);
	}

	private void dfs(String currentNode, HashMap<String, ArrayList<String>> adjList2, HashSet<String> visited,
			ArrayList<String> orderOfVisit) {
		if (currentNode == null) {
			return;
		}
		visited.add(currentNode);
		orderOfVisit.add(currentNode);
		ArrayList<String> list = adjList2.get(currentNode);
		if (list == null) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			String current = list.get(i);
			if (!visited.contains(current)) {
				dfs(current, adjList2, visited, orderOfVisit);
			}
		}
		return;
	}

	public static String inputFromKeyboard() {
		InputStreamReader in = null;
		in = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(in);
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return s;
	}

	public static HashMap<String, ArrayList<String>> inputFromFile(String fileName) {

		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		try {
			while ((s = br.readLine()) != null) {
				String[] split = s.split(",");
				String source = split[0];
				String destination = split[1];

				if (!map.containsKey(source)) {
					ArrayList<String> li = new ArrayList<>();
					li.add(destination);
					map.put(source, li);
				} else {
					ArrayList<String> li = map.get(source);
					li.add(destination);
				}

				if (!map.containsKey(destination)) {
					ArrayList<String> li = new ArrayList<>();
					li.add(source);
					map.put(destination, li);
				} else {
					ArrayList<String> li = map.get(destination);
					li.add(source);
				}
				list.add(s);
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return map;
	}

	private void sortAdjListAlphabetically(HashMap<String, ArrayList<String>> map) {
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			ArrayList<String> li = entry.getValue();
			Collections.sort(li, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
		}
	}

}
