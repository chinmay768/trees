package BinarySearchTree;

import BinaryTree.Node;

public class ValidateBST {

    public static boolean isValidBST(Node root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(Node root, long minRange, long maxRange) {
        if(root == null) return true;

        if(root.data < minRange || root.data > maxRange) return false;

        return isValidBST(root.left, minRange, root.data) &&
                isValidBST(root.right, root.data, maxRange);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.right.left = new Node(11);
        root.right.right = new Node(14);

        System.out.println(isValidBST(root));
    }
}
