package BinarySearchTree;

import BinaryTree.Node;
public class SearchInBST {

    public static Node searchBST(Node root, int val) {
        while (root != null && root.data != val){
            root = root.data > val? root.left : root.right;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
