package io.github.kamil_jankowski.task4;

public class ArbitraryPointer {
    public static void main(String[] args) {
        System.out.println("Task 4: Copy Linked List with Arbitrary Pointer\n");

        ArbitraryLinkedList list = new ArbitraryLinkedList(5, 4, 3, 2, 1);
        setUpArbitraryReferences(list);

        System.out.println("Original list:");
        list.print();
        System.out.println();

        final ArbitraryLinkedList copiedList = ListDuplicator.copy(list);
        System.out.println("Copied list: ");
        copiedList.print();
    }

    private static void setUpArbitraryReferences(ArbitraryLinkedList list) {
        list.head.arbitrary = list.head.next.next;                          // 1 -> 3
        list.head.next.arbitrary = list.head;                               // 2 -> 1
        list.head.next.next.arbitrary = list.head.next.next.next.next;      // 3 -> 5
        list.head.next.next.next.arbitrary = list.head.next.next;           // 4 -> 3
        list.head.next.next.next.next.arbitrary = list.head.next;           // 5 -> 2
    }
}
