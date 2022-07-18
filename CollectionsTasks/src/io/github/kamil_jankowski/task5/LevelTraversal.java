package io.github.kamil_jankowski.task5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    public static void main(String[] args) {
        System.out.println("Task 5: Level Order Traversal of Binary Tree\n");

        // creating a binary tree and entering the nodes
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(200);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(75);
        tree.root.right.right = new Node(350);

        String traversal = traverseBinaryTreeLevelOrder(tree);

        System.out.println("Level order traversal of binary tree is - ");
        System.out.println(traversal);
    }

    private static String traverseBinaryTreeLevelOrder(BinaryTree tree) {
        StringBuilder traversal = new StringBuilder();

        List<Queue<Node>> queues = new ArrayList<>();
        Queue<Node> currentLevelNodes = new LinkedList<>();
        Queue<Node> nextLevelNodes = new LinkedList<>();

        queues.add(0, currentLevelNodes);
        queues.add(1, nextLevelNodes);

        currentLevelNodes.add(tree.root);
        int level = 0;

        while (!currentLevelNodes.isEmpty()){
            final Node current = currentLevelNodes.poll();
            traversal.append(current.data);

            if (current.left != null) nextLevelNodes.add(current.left);
            if (current.right != null) nextLevelNodes.add(current.right);

            // formatting the output
            if (currentLevelNodes.isEmpty()){
                traversal.append("\n");
                level++;
            // Making nextLevelNodes queue the CURRENT one, empty currentLevelNodes queue to be used as a new NEXT one
                currentLevelNodes = queues.get(level % 2);
                nextLevelNodes = queues.get((level + 1) % 2);
            } else {
                traversal.append(", ");
            }
        }
        return traversal.toString();
    }
}
