import java.util.*;
public class LevelOrderTraversal {

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

    public static void levelorderTraversalRtoL(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }

        }
    }

    public static void levelorderTraversalBtoTAndRtoL(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node curr = queue.poll();
            stack.push(curr.data);

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }

            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }

        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void levelorderTraversalBtoT(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node curr = queue.poll();
            stack.push(curr.data);


            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        levelorderTraversalBtoTAndRtoL(root);
    }
}

// Try using hashmap also
