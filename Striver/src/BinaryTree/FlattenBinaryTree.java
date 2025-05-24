package BinaryTree;

import java.util.Stack;

public class FlattenBinaryTree {
    static Node prev;

    public void flattenRec(Node root){
        if(root == null) return;

        flattenRec(root.right);
        flattenRec(root.left);

        root.right = prev; // perv will always point to previous processed subtree root
        root.left = null;

        prev = root;
    }

    // TC: O(N)    SC: O(N)
    public void flatten(Node root) {
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            Node curr = st.pop();

            if(curr.right != null) st.push(curr.right);

            if(curr.left != null) st.push(curr.left);

            if(!st.isEmpty()) curr.right = st.peek(); // Don't pop bc it to trace back

            curr.left = null;
        }
    }


    public static void main(String[] args) {

    }
}
