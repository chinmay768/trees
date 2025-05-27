package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

//LC: 173. Binary Search Tree Iterator
public class BSTIterator {
    private final Stack<Node> stack = new Stack<>();
    // TC: O(1) // Most of the time we are pushing only 1 elm but sometimes we push all the left elms
    // SC: O(H)
    public BSTIterator(Node root) {
       pushAll(root);
    }

    public int next() {
        Node curr = stack.pop();
        pushAll(curr.right);
        return curr.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(Node root){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {

    }
}
