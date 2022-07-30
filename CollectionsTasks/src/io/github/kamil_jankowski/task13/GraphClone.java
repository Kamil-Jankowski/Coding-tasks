package io.github.kamil_jankowski.task13;

import java.util.*;

public class GraphClone {
    public static void main(String[] args) {
        System.out.println("Task 13: Clone a graph");

        // Define nodes
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        // Connect nodes
        root.addNeighbour(node2);
        root.addNeighbour(node4);
        node2.addNeighbour(node3);
        node2.addNeighbour(node5);
        node3.addNeighbour(root);
        node3.addNeighbour(node4);
        node4.addNeighbour(node3);
        node4.addNeighbour(node5);
        node5.addNeighbour(node2);

        System.out.println("Reference graph:");
        printGraph(root);

        Node cloned = cloneGraph(root);
        System.out.println("Cloned graph:");
        printGraph(cloned);
    }


    private static Node cloneGraph(Node node){
        if (node == null) return null;
        Map<Node, Node> clones = new HashMap<>();
        return cloneGraph(node, clones);
    }

    private static Node cloneGraph(Node original, Map<Node, Node> clones) {
        Node clone = clones.get(original);
//        System.out.println("Cloning: " + original.value);
        if (clones.containsKey(original)){
//            System.out.println("Node" + original.value + " already cloned");
//            System.out.println("Returning ClonedNode" + clones.get(original).value);
            return clone;
        } else {
            clone = new Node(original.value);
//            System.out.println("ClonedNode" + clone.value + " created. Inserting to clones map");
            clones.put(original, clone);
//            System.out.println("Clones map contains: " + clones.keySet().size() + " original-to-clone pairs");
        }

        for (Node neighbour : original.neighbours){
//            System.out.println("Submitting neighbour-" + neighbour.value + " of Node" + original.value + " to be cloned");
            Node clonedNeighbour = cloneGraph(neighbour, clones);
            clones.get(original).addNeighbour(clonedNeighbour);
        }

//        System.out.println("Returning cloned node: ClonedNode" + clone.value);
        return clone;
    }

    /**
     * Prints graph from a given node using breadth first search
     * @param node - starting node of print
     */
    public static void printGraph(Node node)
    {
        Queue<Node> nodesToTraverse = new LinkedList<>();
        nodesToTraverse.add(node);

        Set<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(node);

        while (!nodesToTraverse.isEmpty())
        {
            Node n = nodesToTraverse.poll();
            System.out.println("Value of Node: " + n.value);
            System.out.print("Node neighbours: ");
            n.printNeighbours();
            System.out.println();
            System.out.println("Address of Node: " + n);

            if (!n.neighbours.isEmpty())
            {
                Set<Node> v = n.neighbours;
                for (Node g : v)
                {
                    if (!visitedNodes.contains(g))
                    {
                        nodesToTraverse.add(g);
                        visitedNodes.add(g);
                    }
                }
            }
        }
        System.out.println();
    }
}
