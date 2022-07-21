package io.github.kamil_jankowski.task13;

import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    List<Node> neighbours;

    Node(){
        value = 0;
        neighbours = new ArrayList<>();
    }

    Node(int value){
        this.value = value;
        neighbours = new ArrayList<>();
    }

    Node(int value, List<Node> neighbours){
        this.value = value;
        this.neighbours = neighbours;
    }
}
