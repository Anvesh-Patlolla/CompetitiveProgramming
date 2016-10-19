package ai.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SearchUSA {

	private static String FILE_LOCATION = "/Users/anvesh/git/CompetitiveProgramming/Sample/src/ai/hw2/citiesDistances";
	private static String CITY_DETAILS_LOCATION = "/Users/anvesh/git/CompetitiveProgramming/Sample/src/ai/hw2/citiesHeuristic";

	private static final String ASTAR_ALGO = "astar";
	private static final String GREEDY_ALGO = "greedy";
	private static final String UNIFORM_ALGO = "uniform";
	private HashMap<String, ArrayList<AdjacencyElement>> adjList = new HashMap<String, ArrayList<AdjacencyElement>>();

	private HashMap<String, City> cityDetails = new HashMap<String, City>();

	private String algo = ASTAR_ALGO;

	public HashMap<String, City> generateCityDetails(String fileName) {
		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;

		cityDetails = new HashMap<String, City>();

		try {
			while ((s = br.readLine()) != null) {
				if (s == null || s.length() == 0) {
					continue;
				}
				String[] split = s.split(",");
				String sourceName = split[0];
				float latitude = Float.parseFloat(split[1]);
				float longitude = Float.parseFloat(split[2]);
				cityDetails.put(sourceName, new City(sourceName, latitude, longitude));
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return cityDetails;
	}

	public HashMap<String, ArrayList<AdjacencyElement>> inputFromFile(String fileName) {

		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(in);
		String s = null;

		adjList = new HashMap<String, ArrayList<AdjacencyElement>>();

		try {
			while ((s = br.readLine()) != null) {
				if (s == null || s.length() == 0) {
					continue;
				}
				String[] split = s.split(",");
				String sourceName = split[0];
				String destinationName = split[1];
				int distance = Integer.parseInt(split[2]);
				City source = cityDetails.get(sourceName);
				City destination = cityDetails.get(destinationName);

				if (!adjList.containsKey(sourceName)) {
					ArrayList<AdjacencyElement> li = new ArrayList<AdjacencyElement>();
					li.add(new AdjacencyElement(destination, distance));
					adjList.put(sourceName, li);
				} else {
					ArrayList<AdjacencyElement> li = adjList.get(sourceName);
					li.add(new AdjacencyElement(destination, distance));
				}

				if (!adjList.containsKey(destinationName)) {
					ArrayList<AdjacencyElement> li = new ArrayList<AdjacencyElement>();
					li.add(new AdjacencyElement(source, distance));
					adjList.put(destinationName, li);
				} else {
					ArrayList<AdjacencyElement> li = adjList.get(destinationName);
					li.add(new AdjacencyElement(source, distance));
				}

			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return adjList;
	}

	private void display() {
		for (Entry<String, ArrayList<AdjacencyElement>> entry : adjList.entrySet()) {
			String source = entry.getKey();
			System.out.print(source + ":");
			ArrayList<AdjacencyElement> neighbours = entry.getValue();
			if (neighbours != null && neighbours.size() > 0) {
				for (AdjacencyElement neighbour : neighbours) {
					System.out.print(neighbour.toString() + ",");
				}
				System.out.println();
			}
		}
	}

	// java SearchUSA searchtype srccityname destcityname
	public static void main(String[] args) {

		String searchType = args[0];// "uniform";//
		String source = args[1];// "japan";//
		String destination = args[2]; // "desMoines";//

		SearchUSA obj = new SearchUSA();
		obj.generateCityDetails(CITY_DETAILS_LOCATION);
		obj.inputFromFile(FILE_LOCATION);
		// obj.display();

		if (searchType.equalsIgnoreCase("astar")) {
			obj.astar(source, destination);
		} else if (searchType.equalsIgnoreCase("greedy")) {
			obj.greedy(source, destination);
		} else if (searchType.equalsIgnoreCase("uniform")) {
			obj.uniform(source, destination);
		}
	}

	private void uniform(String source, String destination) {
		algo = UNIFORM_ALGO;
		astar(source, destination);
	}

	private void greedy(String source, String destination) {
		algo = GREEDY_ALGO;
		astar(source, destination);
	}

	int expansionCounter = 0;

	private void astar(String source, String destination) {
		expansionCounter = 0;
		// algo = ASTAR_ALGO;
		// Set source heuristic to zero;
		City startCity = cityDetails.get(source);
		startCity.distanceFromSource = 0;
		startCity.heuristic = 0;

		PriorityQueue<City> queue = new PriorityQueue<City>(new Comparator<City>() {
			@Override
			public int compare(City o1, City o2) {
				return (int) ((o1.distanceFromSource + o1.heuristic) - (o2.distanceFromSource + o2.heuristic));
			}
		});

		queue.add(cityDetails.get(source));
		System.out.print("expanded nodes: ");
		while (!queue.isEmpty()) {

			City head = queue.remove();
			System.out.print(head.city + ",");
			expansionCounter++;

			if (head.city.equals(destination)) {
				System.out.println("\nnumber of nodes expanded: " + expansionCounter);
				printPath(destination, source);
				return;
			}
			ArrayList<AdjacencyElement> list = adjList.get(head.city);
			for (int i = 0; i < list.size(); i++) {
				AdjacencyElement adjacencyElement = list.get(i);
				udpateCityHeuristic(adjacencyElement, destination, head.city, queue);
			}
		}
	}

	private void printPath(String destination, String source) {
		String temp = destination;
		ArrayList<String> cities = new ArrayList<String>();
		while (!destination.equals(source)) {
			// City t1 = cityDetails.get(destination);
			// System.out.println("city:" + destination + " cost:" +
			// (t1.heuristic + t1.distanceFromSource));
			cities.add(destination);
			destination = cityDetails.get(destination).previousCity;
		}
		cities.add(source);
		System.out.println();
		System.out.print("nodes in the solution path: ");
		for (int i = cities.size() - 1; i > -1; i--) {
			System.out.print(cities.get(i) + ",");
		}

		System.out.println("\nnumber of nodes in the path: " + cities.size());
		City c1 = cityDetails.get(temp);
		if (!algo.equals(GREEDY_ALGO)) {
			System.out.println("\ntotal distance : " + (c1.distanceFromSource + c1.heuristic));
		} else {
			System.out.println("\ntotal distance : " + greedyTotalDistance(cities));
		}
	}

	private int greedyTotalDistance(ArrayList<String> cities) {

		int retVal = 0;
		for (int i = 0; i < cities.size() - 1; i++) {
			String source = cities.get(i);
			String destination = cities.get(i + 1);

			ArrayList<AdjacencyElement> list = adjList.get(source);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).city.city.equals(destination)) {
					retVal += list.get(j).distance;
					break;
				}
			}
		}
		return retVal;
	}

	private void udpateCityHeuristic(AdjacencyElement adjacencyElement, String destination, String previousCity,
			PriorityQueue<City> queue) {
		double heuristicMeasure = 0;
		int distanceFromSouce = 0;

		City previous = cityDetails.get(previousCity);
		if (algo.equalsIgnoreCase(ASTAR_ALGO) || algo.equalsIgnoreCase(GREEDY_ALGO)) {
			heuristicMeasure = heuristic(adjacencyElement.city.city, destination);
		}

		if (algo.equalsIgnoreCase(ASTAR_ALGO) || algo.equalsIgnoreCase(UNIFORM_ALGO)) {
			distanceFromSouce = previous.distanceFromSource + adjacencyElement.distance;
		}

		City currentCity = adjacencyElement.city;
		if (heuristicMeasure + distanceFromSouce < currentCity.heuristic + currentCity.distanceFromSource) {

			currentCity.distanceFromSource = distanceFromSouce;
			currentCity.heuristic = heuristicMeasure;
			currentCity.previousCity = previousCity;
			queue.remove(currentCity);
			queue.add(currentCity);
		}

	}

	private double heuristic(String c1, String c2) {

		City city1 = cityDetails.get(c1);
		City city2 = cityDetails.get(c2);
		// sqrt((69.5 * (Lat1 - Lat2)) ^ 2 + (69.5 * cos((Lat1 + Lat2)/360 * pi)
		// * (Long1 - Long2)) ^ 2)

		float Lat1 = city1.latitude;
		float Lat2 = city2.latitude;
		float Long1 = city1.longitude;
		float Long2 = city2.longitude;
		double pi = Math.PI;

		double heuristic = Math.sqrt(Math.pow((69.5 * (Lat1 - Lat2)), 2)
				+ Math.pow((69.5 * Math.cos((Lat1 + Lat2) / 360 * pi) * (Long1 - Long2)), 2));
		return heuristic;
	}

	private static class City {

		public City(String name, float latitude, float longitude) {
			this(latitude, longitude);
			this.city = name;
		}

		public City(float latitude, float longitude) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;

			distanceFromSource = Integer.MAX_VALUE / 2;
			heuristic = 0;// Integer.MAX_VALUE / 2;
		}

		public City(String city) {
			super();
			this.city = city;
		}

		@Override
		public String toString() {
			return "City [latitude=" + latitude + ", longitude=" + longitude + ", city=" + city
					+ ", distanceFromSource=" + distanceFromSource + ", heuristic=" + heuristic + ", previousCity="
					+ previousCity + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + Float.floatToIntBits(latitude);
			result = prime * result + Float.floatToIntBits(longitude);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			City other = (City) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
				return false;
			if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
				return false;
			return true;
		}

		float latitude;
		float longitude;
		String city;

		int distanceFromSource;
		double heuristic;
		String previousCity;
	}

	private static class AdjacencyElement {
		public AdjacencyElement(City city, int distance) {
			super();
			this.city = city;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "AdjacencyElement [city=" + city.toString() + ", distance=" + distance + "]";
		}

		City city;
		int distance;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AdjacencyElement other = (AdjacencyElement) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			return true;
		}

	}

}
