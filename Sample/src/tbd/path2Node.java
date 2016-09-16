package tbd;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//in this program though I have implemented the State for the nodes
//its not completely necessary since I am returning as soon as I get
//the destination node

public class path2Node {
	enum State {UNVISITED, VISIT_STARTED, VISIT_FINISHED};
	private static class Node{
		State state;
		String name;
		ArrayList<Node> adjList = new ArrayList<Node>();
		public Node(String name){
			this.name=name;
			this.state=State.UNVISITED;
			//this.adjList=null;
		}
	}
	private static ArrayList<Node> graph = new ArrayList<Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node srcNode=init();
		display(graph);
		System.out.println(findPath(srcNode,"d"));
	}
	
	private static boolean findPath(Node srcNode, String dest){
		Queue<Node> q = new LinkedList<Node>();
		Node n;
		q.add(srcNode);
		//int count=1;
		//System.out.println(srcNode.name+" visited");
		
		while(!q.isEmpty()){
			//System.out.println(count);
			
			n=q.remove();
			System.out.println(n.name+" visited");
			System.out.println(n.state);
			n.state=State.VISIT_STARTED;
			System.out.println(n.state);
			for(Node e : n.adjList){
				//System.out.println(n.adjList);
				if(e.name.compareTo(dest)==0){
					System.out.println(e.name+" found");
					return true;
				}
				if(e.state==State.UNVISITED) q.add(e);
			}
			for(Node item: q){
				System.out.print(item.name+", ");
			}
			//display(graph);
			System.out.println();
			n.state=State.VISIT_FINISHED;
			
			//count++;
		}
		return false;
	}
	
	private static Node init(){
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");

		Node f = new Node("f");
		
		b.adjList.add(new Node("a"));
		b.adjList.add(new Node("f"));
		//node.adjList.add(new Node("d"));
		graph.add(b);
		c.adjList.add(new Node("b"));
		c.adjList.add(new Node("d"));
		c.adjList.add(new Node("e"));
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		
		
		a.adjList.add(b);
		a.adjList.add(c);
		Node srcNode = a;
		graph.add(a);
		return srcNode;
	}
	
	private static void display(ArrayList<Node> gr){
		System.out.println();
		for(Node node: gr){
			System.out.print(node.name+"--->");
			for(Node adj: node.adjList)
				System.out.print(adj.name);
			System.out.print("---->"+node.state);
			System.out.println();
		}
	}

}