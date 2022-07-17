package io.github.kamil_jankowski.task4;

import java.util.HashMap;
import java.util.Map;

class ListDuplicator {

    static ArbitraryLinkedList copy(ArbitraryLinkedList listToBeCopied) {
        Node originalCurrentNode = listToBeCopied.head;
        Node copiedCurrentNode;

        Map<Node, Node> map = new HashMap<>();

        while(originalCurrentNode != null){
            copiedCurrentNode = new Node(originalCurrentNode.data);
            map.put(originalCurrentNode, copiedCurrentNode);
            originalCurrentNode = originalCurrentNode.next;
        }

        originalCurrentNode = listToBeCopied.head;

        while(originalCurrentNode != null){
            copiedCurrentNode = map.get(originalCurrentNode);
            copiedCurrentNode.next = originalCurrentNode.next;
            copiedCurrentNode.arbitrary = originalCurrentNode.arbitrary;

            originalCurrentNode = originalCurrentNode.next;
        }

        final Node copiedListHead = map.get(listToBeCopied.head);
        return new ArbitraryLinkedList(copiedListHead);
    }
}
