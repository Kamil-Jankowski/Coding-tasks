package io.github.kamil_jankowski.task6;

class BinarySearchTreeAnalyzer {

    /*Previously visited node of a tree*/
    private static Node previous;

    public static void main(String[] args) {
        System.out.println("Task 6: Determine if a binary tree is a binary search tree");

        BinaryTree bst = new BinaryTree();
        bst.root = new Node(100);
        bst.root.left = new Node(50);
        bst.root.right = new Node(200);
        bst.root.left.left = new Node(25);
        bst.root.left.right = new Node(75);
        bst.root.right.left = new Node(125);
        bst.root.right.right = new Node(300);

        BinaryTree nbst = new BinaryTree();
        nbst.root = new Node(100);
        nbst.root.left = new Node(50);
        nbst.root.right = new Node(200);
        nbst.root.left.left = new Node(25);
        nbst.root.left.right = new Node(75);
        nbst.root.right.left = new Node(90);
        nbst.root.right.right = new Node(300);

        if (isBST(bst))
            System.out.println("bst IS BST");
        else
            System.out.println("bst is not a BST");

        if (isBST(nbst))
            System.out.println("nbst IS BST");
        else
            System.out.println("nbst is not a BST");
    }

    /***
     * Executes binary search tree checking method for root node of a tree.
     * @param tree - binary tree to be checked
     * @return true - if tree is binary search tree, false otherwise
     */
    static boolean isBST(BinaryTree tree) {
        previous = null;
        return isBST(tree.root);
    }

    /***
     * Performs inorder traversal recursive check if given node is a part of binary search tree.
     * Steps 1, 2, 4 are parts of inorder traversal. Step 3 is business logic step responsible for verification.
     * @param node - node of a binary tree to be checked or null
     * @return true - if node belongs to binary search tree, false otherwise
     */
    private static boolean isBST(Node node) {
        /*Step 1: Check if node is not null i.e. recursive method has been called from the last leaf of given branch.*/
        if (node == null) return true;

        /*Step 2: Check left subtree for given node. If left subtree is not binary search tree, ceases the execution.*/
        if (!isBST(node.left)) return false;

        /*Step 3.1: Analyze current node if it is a part of a binary search tree.
        * If previously visited node is not null (i.e. we are not on a left leaf),
        * and
        * current node value is less/equal previously visited node value,
        * then
        * ceases the execution since this node is not a part of binary search tree.
        * */
        if (previous != null && node.data <= previous.data) return false;

        /*Step 3.2: Assigns current node as previously visited one.*/
        previous = node;

        /*Step 4: Check right subtree for given node. If a subtree is not binary search tree, returns false.*/
        return isBST(node.right);
    }
}
