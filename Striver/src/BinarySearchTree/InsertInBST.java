package BinarySearchTree;

import BinaryTree.Node;
import BinaryTree.LevelOrderTraversal;

public class InsertInBST {
    // Find where the node can be inserted (it's always a leaf node)
    public static Node insertInBst(Node root, int key){
        if(root == null) return new Node(key);
        Node curr = root;
        while (curr != null){
            if(curr.data <= key){
                if(curr.right != null) curr = curr.right;
                else {
                    curr.right = new Node(key);
                    break;
                }
            }else {
                if(curr.left != null) curr = curr.left;
                else {
                    curr.left = new Node(key);
                    break;
                }
            }
        }
        return root;
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

        Node newNode = insertInBst(root, 7);
        System.out.println(LevelOrderTraversal.levelOrderTraversal(newNode));
    }
}
