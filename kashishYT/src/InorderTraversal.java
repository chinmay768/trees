public class InorderTraversal {

    public static void inorderTraversal(Node root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inorderTraversal(root);
    }
}
