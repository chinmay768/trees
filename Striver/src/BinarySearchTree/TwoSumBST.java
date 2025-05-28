package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

class BSTIterator2 {
    Stack<Node> st = new Stack<>();
    boolean isReverse;
    public BSTIterator2(Node root, boolean isReverse) {
        this.isReverse = isReverse;
        pushAll(root);
    }

    public int next() {
        Node curr = st.pop();
        if(isReverse)
            pushAll(curr.left);
        else
            pushAll(curr.right);
        return curr.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(Node root){
        while (root != null){
            st.push(root);
            if(isReverse)
                root = root.right;
            else
                root = root.left;
        }
    }
}

public class TwoSumBST {

    // Naive soln is to do inorder traversal and store the result in a list then sort it
    // Then simply apply two pointers on this
    // TC: O(2n)   SC: O(N)

    //
    public boolean findTarget(Node root, int k) {
        if(root == null) return false;

        BSTIterator2 left = new BSTIterator2(root, false);
        BSTIterator2 right = new BSTIterator2(root, true);

        int i = left.next();
        int j = right.next();
        while (i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = left.next();
            else j = right.next();
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
