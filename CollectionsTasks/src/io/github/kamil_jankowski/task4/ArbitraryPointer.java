package io.github.kamil_jankowski.task4;

public class ArbitraryPointer {
    public static void main(String[] args) {
        System.out.println("Task 4: Copy Linked List with Arbitrary Pointer");

        ArbitraryLinkedList originalList = new ArbitraryLinkedList(new Node(5));
        originalList.push(4);
        originalList.push(3);
        originalList.push(2);
        originalList.push(1);

        originalList.print();
    }
}
