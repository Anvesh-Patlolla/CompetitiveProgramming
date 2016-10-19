package karat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class intuit {

	public ArrayList<String> readIds(String fileName) {

		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			s = br.readLine();
			while ((s = br.readLine()) != null) {
				String[] split = s.split(",");
				ArrayList<String> li = new ArrayList<>();
				li.add(null);
				map.put(split[0], li);
				// list.add(split[0]);
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return list;
	}

	HashMap<String, List<String>> map = null;

	public static void main(String[] args) {
		intuit intu = new intuit();
		intu.readIds(".csv");
		intu.readFriendShips("");
		intu.displayAdjacencyList();
	}

	private void displayAdjacencyList() {
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> value = entry.getValue();
			String key = entry.getKey();
			System.out.print(key + ": ");
			for (int i = 0; i < value.size(); i++) {
				if (value.get(i) != null) {
					System.out.print(value.get(i) + ",");
				}
			}
			System.out.println();
		}

	}

	private void readFriendShips(String fileName) {

		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;
		try {
			s = br.readLine();
			while ((s = br.readLine()) != null) {
				String[] split = s.split(",");
				String f1 = split[0];
				String f2 = split[1];
				List<String> f1List = map.get(f1);
				f1List.add(f2);
				List<String> f2List = map.get(f2);
				f2List.add(f1);
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return;
	}
}
