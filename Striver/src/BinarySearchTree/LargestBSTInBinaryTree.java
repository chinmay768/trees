package BinarySearchTree;

import BinaryTree.Node;

class NodeValue{
    int maxSize;
    int minNode;
    int maxNode;

    NodeValue(int maxSize, int minNode, int maxNode){
        this.maxSize = maxSize;
        this.minNode = minNode;
        this.maxNode = maxNode;
    }
}

class BSTInfo {
    int min;
    int max;
    int mxSz;

    BSTInfo(int mn, int mx, int sz) {
        min = mn;
        max = mx;
        mxSz = sz;
    }
}

public class LargestBSTInBinaryTree {

    //Naive Soln is to visit every node and check for valid bst and maintain
    // a global max size variable

    public static NodeValue largestBstHelper(Node root){
        if(root == null) return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if(root.data > left.maxNode && root.data < right.minNode){ // valid BST
            return new NodeValue(1 + left.maxSize + right.maxSize,
                    Math.min(left.minNode, root.data), Math.max(right.maxNode, root.data));
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }



    static BSTInfo largestBstBt(Node root) {
        if (root == null)
            return new BSTInfo(Integer.MAX_VALUE,
                    Integer.MIN_VALUE, 0);

        BSTInfo left = largestBstBt(root.left);
        BSTInfo right = largestBstBt(root.right);

        // Check if the current subtree is a BST
        if (left.max < root.data && right.min > root.data) {
            return new BSTInfo(Math.min(left.min, root.data),
                    Math.max(right.max, root.data),
                    1 + left.mxSz + right.mxSz);
        }

        return new BSTInfo(Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.mxSz, right.mxSz));
    }

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(40);
        root.left.left = new Node(14);
        root.left.right = new Node(18);
        root.left.right.left = new Node(16);
        root.left.right.right = new Node(19);
        root.left.left.right = new Node(17);
        root.right.left = new Node(30);
        root.right.right = new Node(60);
        root.right.right.left = new Node(50);

        System.out.println(largestBstHelper(root).maxSize);
    }
}
