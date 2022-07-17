package io.github.kamil_jankowski.task4;

class Node {
    int data;
    Node next;
    Node arbitrary;

    Node(int data) {
        this.data = data;
        this.next = this.arbitrary = null;
    }
}
