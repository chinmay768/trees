package BinaryTree;

public class LowestCommonAncestor {

    public static Node lca(Node root, Node node1, Node node2){
        if(root == null || root == node1 || root == node2) return root;

        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right, node1, node2);

        if(left != null && right != null) return root;
        else if(left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, root.left.left, root.left.right).data);
    }
}
