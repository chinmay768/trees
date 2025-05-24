package BinarySearchTree;

import BinaryTree.LevelOrderTraversal;
import BinaryTree.Node;

public class DeleteInBST {

    public static Node deleteNode(Node root, int key) {
        if(root == null) return null;
        if(root.data == key) return helper(root);

        Node curr = root;
        while (curr != null) {
            if(curr.data < key){
                if(curr.right != null && curr.right.data == key){
                    curr.right = helper(curr.right);
                    break;
                }else {
                    curr = curr.right;
                }
            }else {
                if(curr.left != null && curr.left.data == key) {
                    curr.left = helper(curr.left);
                    break;
                }else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }

    public static Node helper(Node root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        Node left = root.left;
        Node rightLastLeft = findLastLeft(root.right);
        rightLastLeft.left = left;
        return root.right;
    }

    public static Node findLastRight(Node root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }

    public static Node findLastLeft(Node root){
        if(root.left == null) return root;

        return findLastLeft(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);

        deleteNode(root, 1);

        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));

    }
}
