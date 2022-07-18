package io.github.kamil_jankowski.task5;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {
    public static void main(String[] args) {
        System.out.println("Task 5: Level Order Traversal of Binary Tree\n");

        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(200);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(75);
        tree.root.right.right = new Node(350);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(tree);
    }

    private static void printLevelOrder(BinaryTree tree) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(tree.root);

        while (!nodes.isEmpty()){
            final Node current = nodes.peek();

            if (current.left != null) nodes.add(current.left);
            if (current.right != null) nodes.add(current.right);

            System.out.println(nodes.poll().data);
        }
    }
}
