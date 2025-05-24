package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTypesInOneTraversal {

    private static class Pair{
        Node first;
        Integer second;

        public Node getFirst() {
            return first;
        }

        public Pair(Node first, Integer second) {
            this.second = second;
            this.first = first;
        }

        public void setFirst(Node first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }
    }

    public static void preInPostTraversal(Node root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair curr = st.pop();

            if(curr.second == 1){
                pre.add(curr.first.data);
                curr.second++;
                st.push(curr);

                if(curr.first.left != null){
                    st.push(new Pair(curr.first.left, 1));
                }
            }else if(curr.second == 2){
                in.add(curr.first.data);
                curr.second++;
                st.push(curr);

                if(curr.first.right != null){
                    st.push(new Pair(curr.first.right, 1));
                }
            }else {
                post.add(curr.first.data);
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preInPostTraversal(root);
    }
}
