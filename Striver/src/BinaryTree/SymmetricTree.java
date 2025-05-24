package BinaryTree;

public class SymmetricTree {

    public static boolean isSymmetric(Node root){

        return root == null || isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(Node root1, Node root2){
        if(root1 == null || root2 == null) return root1 == root2;

        if(root1.data != root2.data) return false;

        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println(isSymmetric(root));
    }
}
