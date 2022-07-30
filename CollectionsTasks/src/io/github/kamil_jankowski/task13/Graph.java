package io.github.kamil_jankowski.task13;

import java.util.Set;

class Graph {

    Set<Node> graphNodes;
    Node root;

    Graph(Node root){
        this.root = root;
    }

    public Graph(Set<Node> nodes) {
        this.graphNodes = nodes;
    }

    public void print() {
        for (Node node : graphNodes){
            System.out.print("Node: " + node.value + " connects to: ");
            node.printNeighbours();
            System.out.println();
        }
    }
}
