package BinaryTree;

import java.util.*;

public class PostorderTraversal {

    public static void postorderRec(Node root){
        if(root == null) return;

        postorderRec(root.left);
        postorderRec(root.right);
        System.out.println(root.data);
    }

    public static void iterativePostorderTraversal2Stack(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return;

        st1.push(root);
        while (!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if(root.left != null) st1.add(root.left);
            if(root.right != null) st1.add(root.right);
        }

        while (!st2.isEmpty()){
            list.add(st2.pop().data);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        iterativePostorderTraversal2Stack(root);
    }
}
