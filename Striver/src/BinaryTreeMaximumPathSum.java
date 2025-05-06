public class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        if(root == null) return 0;

        int ls = Math.max(0, maxPathSum(root.left)); // Max(0) To handle the case where -ve is returned so we will not consider it while evaluating max Sum
        int rs = Math.max(0, maxPathSum(root.right));

        maxSum = Math.max(maxSum, root.data + ls + rs);

        return root.data + Math.max(ls, rs);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        maxPathSum(root);

        System.out.println(maxSum);
    }
}
