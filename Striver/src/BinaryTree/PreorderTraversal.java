package BinaryTree;

import java.util.Stack;

public class PreorderTraversal {

    public static void printPreorderRecursive(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data);
        printPreorderRecursive(root.left);
        printPreorderRecursive(root.right);
    }

    public static void printPreorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        if(root == null) return;
        st.push(root);

        while (!st.isEmpty()){
            Node currNode = st.pop();
            System.out.println(currNode.data);

            if(currNode.right != null)
                st.push(currNode.right);
            if(currNode.left != null)
                st.push(currNode.left);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        printPreorderIterative(root);
    }
}
