package BinarySearchTree;

import BinaryTree.Node;

public class RecoverBST {

    // Naive way is to store inorder traversal and sort it
    // Then again do inorder traversal and put values from sorted list to BST
    // TC: 2N + NlogN    SC: O(N)


    static Node prev = null;
    static Node first = null;
    static Node middle = null;
    static Node last = null;
    // TC: O(N)    SC: O(N)
    public void recoverTree(Node root) {
        inorder(root);

        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }else if(first != null && last == null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    public static void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
                middle = root;
            }else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }


    public static void main(String[] args) {

    }
}
