package io.github.kamil_jankowski.task4;

class ArbitraryLinkedList {
    Node head;

    ArbitraryLinkedList(Node head){
        this.head = head;
    }

    ArbitraryLinkedList(int[] nodesData){
        for (int data : nodesData) {
            this.push(data);
        }
    }

    void push(int data){
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    void print(){
        Node currentNode = head;
        while (currentNode != null) {
            Node arbitrary = currentNode.arbitrary;
            Node next = currentNode.next;
            final int arbitraryData = arbitrary != null ? arbitrary.data : -1;
            final int currentData = currentNode.data;
            final int nextData = next != null ? next.data : -1;
            System.out.printf("Data = %d, Next pointer = %d, Arbitrary pointer = %d%n", currentData, nextData, arbitraryData);

            currentNode = currentNode.next;
        }
    }
}
