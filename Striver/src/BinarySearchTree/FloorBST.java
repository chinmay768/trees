package BinarySearchTree;

import BinaryTree.Node;

public class FloorBST {

    public static int findFloor(Node root, int key){
        Node curr = root;
        int floor = Integer.MAX_VALUE;
        while (curr != null){
            if(curr.data == key) {
                floor = curr.data;
                return floor;
            }else if(curr.data < key){
                floor = curr.data;
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        return floor;
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

        System.out.println(findFloor(root, 6));
    }
}