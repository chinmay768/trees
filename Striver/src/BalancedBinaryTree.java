public class BalancedBinaryTree {

    public static boolean isBalancedNaive(Node root) {
        if(root == null) return true;

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        if(Math.abs(lh - rh) > 1) return false;

        boolean checkL = isBalancedNaive(root.left);
        boolean checkR = isBalancedNaive(root.right);

        return checkL && checkR;
    }

    public static int heightOfTree(Node root){
        if(root == null) return 0;

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static int isBalanced(Node root){
        if(root == null) return 0;

        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);

        if(Math.abs(lh - rh) > 1) return -1;

        if(lh == -1 || rh == -1) return -1; // Extra condition which is not handled by above condition

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isBalanced(root));
    }
}
