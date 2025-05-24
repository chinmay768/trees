package BinarySearchTree;

import BinaryTree.Node;

public class CeilBST {

    public static int findCeil(Node root, int key){
        Node curr = root;
        int ceil = Integer.MIN_VALUE;
        while (curr != null){
            if(curr.data == key) {
                ceil = curr.data;
                return ceil;
            }else if(curr.data > key) curr = curr.left;
            else curr = curr.right;
        }

        return ceil;
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


        System.out.println(findCeil(root, 9));
    }
}
