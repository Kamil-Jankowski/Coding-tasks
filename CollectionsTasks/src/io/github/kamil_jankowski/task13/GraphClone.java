package io.github.kamil_jankowski.task13;

import java.util.HashMap;
import java.util.Map;

public class GraphClone {
    public static void main(String[] args) {
        System.out.println("Task 13: Clone a graph");


    }

    private static Node cloneGraph(Node node){
        if (node == null) return null;
        Map<Integer, Node> clones = new HashMap<>();
        return cloneGraph(node, clones);
    }

    private static Node cloneGraph(Node node, Map<Integer, Node> clones) {
        if (clones.containsKey(node.value)) return clones.get(node.value);

        Node clone = new Node(node.value);
        clones.put(node.value, clone);

        for (Node neighbour : node.neighbours) return cloneGraph(neighbour, clones);

        return clone;
    }
}
