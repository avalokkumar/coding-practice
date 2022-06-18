package graph;

import java.util.LinkedList;

public class GraphNode {
    public int id;
    public boolean isVisited;
    public LinkedList<GraphNode> adjacent = new LinkedList<>();

    public GraphNode(int id) {
        this.id = id;
    }
}
