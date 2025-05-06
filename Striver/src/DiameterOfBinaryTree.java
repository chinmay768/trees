public class DiameterOfBinaryTree {
    // Longest path b/w any two nodes

    static int maxDia = 0; // Try to avoid static intance variables as leetcode runs multiple tests simultaneouly which causes issues

    public static void diameterOfBinaryTree(Node root) {
        if(root == null) return;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        maxDia = Math.max(maxDia, leftHeight + rightHeight);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
    }

    public static int heightOfTree(Node root){
        if(root == null) return 0;

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        return 1 + Math.max(lh, rh);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);

        diameterOfBinaryTree(root);

        System.out.println(maxDia);
    }
}
