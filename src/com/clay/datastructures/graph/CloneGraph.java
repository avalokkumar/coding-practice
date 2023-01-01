package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    private Map<Integer, GNode> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        GNode node1 = new GNode(1,
                Arrays.asList(
                        new GNode(2, Arrays.asList(
                                new GNode(1, null),
                                new GNode(3, null)
                        )),
                        new GNode(4))
        );
    }

    public static GNode clone(GNode node) {
        Map<Integer, GNode> valueMap = new HashMap<>();

        return dfs(node, valueMap);
    }

    private static GNode dfs(GNode node, Map<Integer, GNode> valueMap) {
        if (node == null) {
            return null;
        }

        if (valueMap.containsKey(node.val)) {
            return valueMap.get(node.val);
        }

        GNode newNode = new GNode(node.val, new ArrayList<>());
        valueMap.put(node.val, newNode);

        for (GNode child : node.neighbors) {
            newNode.neighbors.add(dfs(child, valueMap));
        }

        return newNode;
    }

    /*public GNode cloneGraph(GNode node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        GNode newNode = new GNode(node.val, new ArrayList<>());
        map.put(node.val, newNode);

        for (GNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }*/

}
