public class PreorderTraversal {
    public static void preorderTraversal(Node root) {
        if(root == null)
            return;

        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        preorderTraversal(root);
    }
}
