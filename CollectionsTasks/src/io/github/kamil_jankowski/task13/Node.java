package io.github.kamil_jankowski.task13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    int value;
    Set<Node> neighbours;

    Node(){
        value = 0;
        this.neighbours = new HashSet<>();
    }

    Node(int value){
        this.value = value;
        this.neighbours = new HashSet<>();
    }

    Node(int value, Set<Node> neighbours){
        this.value = value;
        this.neighbours = neighbours;
    }

    void addNeighbour(Node neighbour){
        this.neighbours.add(neighbour);
    }

    void printNeighbours(){
        for (Node neighbour : neighbours){
            System.out.print(neighbour.value + ",");
        }
    }
}
