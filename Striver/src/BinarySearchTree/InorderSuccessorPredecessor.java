package BinarySearchTree;

import BinaryTree.Node;

public class InorderSuccessorPredecessor {

    public Node inorderSuccessor(Node root, int key){
        Node curr = root;
        Node successor = null;
        while (curr != null){
            if(curr.data <= key){
                curr = curr.right;
            }else {
                successor = curr;
                // Here we don't need to Math.max(curr, successor) because we are moving left
                // whenever we find curr > key
                curr = curr.left;
            }
        }

        return successor;
    }

    public Node inorderPredecessor(Node root, int key){
        Node curr = root;
        Node predecessor = null;

        while (curr != null){
            if(curr.data >= key){
                curr = curr.left;
            }else {
                predecessor = curr;
                curr = curr.right;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {

    }
}
