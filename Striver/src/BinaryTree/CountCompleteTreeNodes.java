package BinaryTree;

public class CountCompleteTreeNodes {
    // Maximum Number of Nodes: 2^h-1
    static int count = 0;
    // Naive Solution
    // TC: O(N)  SC: O(h) h = height of the tree
    public static void inorderTraversal(Node root){
        if(root == null) return;
        count++;

        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    public static int countNodes(Node root){
        if(root == null) return 0;

        int lh = leftHeight(root);// This includes curr node as well
        int rh = rightHeight(root);// This includes curr node as well

        if(lh != 0 && lh == rh) return (int) (Math.pow(2, lh) - 1);

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int leftHeight(Node root){
        int height = 0;
        while (root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    public static int rightHeight(Node root){
        int height = 0;
        while (root != null){
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inorderTraversal(root);
        System.out.println(countNodes(root));
    }
}
