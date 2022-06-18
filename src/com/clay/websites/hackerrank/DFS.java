package websites.hackerrank;

import java.util.LinkedList;

public class DFS {
	private static Node rootNode;

	public DFS() {
		rootNode = new Node(10);
		rootNode.adjacent = new LinkedList<Node>();
		rootNode.adjacent.add(new Node(12));
	}

	private static class Node {
		private int id;
		private LinkedList<Node> adjacent = new LinkedList<>();

		public Node(int id) {
			this.id = id;
		}
	}

}
