import java.util.*;

public class InvertBinaryTree {

    public static void invertBinaryTree(Node root){
        if(root == null){
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static void levelorderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }

            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        invertBinaryTree(root1);

        levelorderTraversal(root1);
    }
}
