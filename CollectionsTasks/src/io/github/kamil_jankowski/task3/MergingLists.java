package io.github.kamil_jankowski.task3;

import java.util.LinkedList;
import java.util.List;

public class MergingLists {
    public static void main(String[] args) {
        System.out.println("Task 3: Merge two sorted linked lists");

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(7);
        list1.add(9);
        list1.add(12);
        list1.add(17);
        list1.add(18);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);
        list2.add(10);
        list2.add(19);
        list2.add(21);

        System.out.println("List 1 - pre:");
        list1.forEach(n -> System.out.print(n + " "));
        System.out.println("\nList 2 - pre:");
        list2.forEach(n -> System.out.print(n + " "));
        System.out.println("\n---------------");

        final List<Integer> merged = mergeLists(list1, list2);

        System.out.println("List 1 - post:");
        list1.forEach(n -> System.out.print(n + " "));
        System.out.println("\nList 2 - post:");
        list2.forEach(n -> System.out.print(n + " "));
        System.out.println("\n---------------");
        System.out.println("Merged list:");
        merged.forEach(n -> System.out.print(n + " "));

    }
    private static List<Integer> mergeLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        List<Integer> merged = new LinkedList<>();

        while (list1.size()>0 || list2.size()>0){
            if (list1.peekFirst() == null) {
                merged.add(list2.pollFirst());
            } else if (list2.peekFirst() == null) {
                merged.add(list1.pollFirst());
            } else if (list1.peekFirst().compareTo(list2.peekFirst()) < 0) {     // -1 l1 < l2; 0 l1 == l2; 1 l1 > l2
                merged.add(list1.pollFirst());
            } else {
                merged.add(list2.pollFirst());
            }
        }

        return merged;
    }

    // Nodal implementation, to be changed and verified at a website
    public static LinkedListNode<Integer> merge_sorted(
            LinkedListNode<Integer> head1,
            LinkedListNode<Integer> head2) {
        //TODO: Write - Your - Code
        return head1;
    }

    private static class LinkedListNode<T> {
        boolean hasNext;
        private T next;

        T next(){
            return next;
        }

        void setNext(T next){
            this.next = next;
        }
    }
}
