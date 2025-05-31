package BinarySearchTree;

import BinaryTree.Node;
import BinaryTree.LevelOrderTraversal;

public class ConstructBSTFromPreorder {

    // TC: O(N * logN)
    public static Node buildBST(Node root, int key){
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if(root.data < key){
            root.right = buildBST(root.right, key);
        }else {
            root.left = buildBST(root.left, key);
        }

        return root;
    }

    public static Node buildBST2(Node root, int key){
        Node curr = root;
        while (true) {
            if(curr.data <= key ){
                if(curr.right != null)
                    curr = curr.right;
                else{
                    curr.right = new Node(key);
                }
            }else if(curr.data > key){
                if(curr.left != null){
                    curr = curr.left;
                }else {
                    curr = new Node(key);
                    break;
                }

            }
        }

        return root;
    }

    public static Node bstFromPreorder(int[] preorder) {
        Node root = new Node(preorder[0]);
        for (int i = 1; i < preorder.length; i++){
            buildBST(root, preorder[i]);
        }
        return root;
    }

    // Try Optimal Approach

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};

        Node root = bstFromPreorder(preorder);

        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));
    }
}