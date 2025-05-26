package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElm {

    static int count = 0;

    public static int morrisInorderTraversal(Node root, int k){
        Node curr = root;

        while (curr != null){
            if(curr.left == null){
                count++;
                if(count == k) return curr.data;
                curr = curr.right;
            }else {
                Node rightMostInLeft = curr.left; // This node will represent inorder predecessor
                while (rightMostInLeft.right != null && rightMostInLeft.right != curr)
                    rightMostInLeft = rightMostInLeft.right;

                if(rightMostInLeft.right == null){
                    rightMostInLeft.right = curr;
                    curr = curr.left;
                }else {
                    rightMostInLeft.right = null;
                    count++;
                    if(count == k) return curr.data;
                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}
