package graph;

import java.util.LinkedList;
import java.util.List;

public class BFSDFSPath {
    public static void main(String[] args) {
        //Build graphnode graph
        GraphNode node1 = new GraphNode(1);
        node1.adjacent = new LinkedList<>();
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        node1.adjacent.add(node2);
        node1.adjacent.add(node3);

        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        node2.adjacent.add(node4);
        node2.adjacent.add(node5);

        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        node4.adjacent.add(node6);
        node5.adjacent.add(node7);
        node3.adjacent.add(node5);

        //BFS
        List<GraphNode> path = new LinkedList<>();
        BFSDFSPath.hasBFSPath(node1, node7, path);
        System.out.println(path);

        //DFS
        path.clear();
        BFSDFSPath.dfs(node1, node7, path);
    }

    private static boolean hasBFSPath(GraphNode src, GraphNode dest, List<GraphNode> path) {
        if (src == null || dest == null) { //if src or dest is null, return
            return false;
        }

        LinkedList<GraphNode> queue = new LinkedList<>(); //queue to store nodes
        queue.add(src); //add src to queue
        src.isVisited = true; //mark src as visited
        while (!queue.isEmpty()) { //while queue is not empty
            GraphNode node = queue.removeFirst(); //remove first node from queue
            path.add(node);     //add node to path
            if (node == dest) { //if node is dest, return
                return true;
            }
            for (GraphNode adjacent : node.adjacent) { //for each adjacent node
                if (!adjacent.isVisited) { //if adjacent node is not visited
                    adjacent.isVisited = true; //mark adjacent node as visited
                    queue.add(adjacent); //add adjacent node to queue
                }
            }
        }

        return false;
    }


    //iterative dfs search
    private static boolean dfs(GraphNode src, GraphNode dest, List<GraphNode> path) {
        if (src == null || dest == null) { //if src or dest is null, return
            return false;
        }

        LinkedList<GraphNode> stack = new LinkedList<>(); //stack to store nodes
        stack.add(src); //add src to stack
        src.isVisited = true; //mark src as visited
        while (!stack.isEmpty()) { //while stack is not empty
            GraphNode node = stack.removeLast(); //remove last node from stack
            path.add(node);     //add node to path
            if (node == dest) { //if node is dest, return
                return true;
            }
            for (GraphNode adjacent : node.adjacent) { //for each adjacent node
                if (!adjacent.isVisited) { //if adjacent node is not visited
                    adjacent.isVisited = true; //mark adjacent node as visited
                    stack.add(adjacent); //add adjacent node to stack
                }
            }
        }

        return false;
    }
    private static void dfsRec(GraphNode src, GraphNode dest, List<GraphNode> path) {
        if (src == null) { //if src is null, return
            return;
        }
        if (src.equals(dest)) { //if src is dest, return
            path.add(src); //add src to path
            return; //return
        }
        path.add(src); // add src to path
        for (GraphNode node : src.adjacent) {   //for each adjacent node
            if (!path.contains(node)) {     //if node is not in path
                dfs(node, dest, path);      //recursive call
            }
        }
    }

}

