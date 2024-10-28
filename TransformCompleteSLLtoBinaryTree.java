import java.util.LinkedList;
import java.util.Queue;

class Lnode {
    int data;
    Lnode next;

    Lnode(int value) {
        data = value;
        next = null;
    }
}

class Tnode {
    int data;
    Tnode left, right;

    Tnode(int value) {
        data = value;
        left = null;
        right = null;
    }
}
public class TransformCompleteSLLtoBinaryTree {

    public static Tnode convert(Lnode head){
        if(head ==  null){
            return null;
        }

        Queue<Tnode> q = new LinkedList<>();

        Tnode root = new Tnode(head.data);
        q.offer(root);

        head = head.next;

        while (head != null){
            Tnode parent = q.poll();

            Tnode leftChild = null, rightChild = null;

            // Create left child
            if (head != null) {
                leftChild = new Tnode(head.data);
                q.add(leftChild);
                head = head.next;
            }

            // Create right child
            if (head != null) {
                rightChild = new Tnode(head.data);
                q.add(rightChild);
                head = head.next;
            }

            // Assign the left and right children of the parent
            parent.left = leftChild;
            parent.right = rightChild;
        }

        return root;

    }

    // Level Order Traversal of the binary tree
    static void levelOrderTraversal(Tnode root) {
        if (root == null) {
            return;
        }

        // Queue to hold nodes at each level
        Queue<Tnode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Tnode currNode = q.poll();

            // Print the current node's data
            System.out.print(currNode.data + " ");

            // Push the left and right children
            // of the current node to the queue
            if (currNode.left != null) {
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
    }


    public static void main(String[] args) {
        Lnode head = new Lnode(10);
        head.next = new Lnode(12);
        head.next.next = new Lnode(15);
        head.next.next.next = new Lnode(25);
        head.next.next.next.next = new Lnode(30);
        head.next.next.next.next.next = new Lnode(36);

        Tnode root = convert(head);
        levelOrderTraversal(root);
    }
}
