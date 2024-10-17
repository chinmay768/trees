public class CheckSumTree {

    public static boolean sumTree = true;

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null)
            return root.data;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        if(root.data != leftSum + rightSum){
            sumTree = false;
        }

        return root.data + leftSum + rightSum;
    }

    public static boolean checkSumTree(Node root){
        sumTree(root);
        return sumTree;
    }

    public static void main(String[] args) {
        Node root1 = new Node(22);
        root1.left = new Node(6);
        root1.right = new Node(5);
        root1.left.left = new Node(4);
        root1.left.right = new Node(2);
        root1.right.left = new Node(1);
        root1.right.right = new Node(4);


        System.out.println(checkSumTree(root1));
    }
}
