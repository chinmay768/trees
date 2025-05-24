package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    static class Tuple{
        Node root;
        int id;

        Tuple(Node root, int id){
            this.root = root;
            this.id = id;
        }
    }

    public static int widthOfBinaryTree(Node root){
        // Considered 1 based indexing
        if(root == null) return 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 1));
        int maxWidth = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            int startId = 0;
            int lastId = 0;
            for (int i = 0; i < size; i++){
                Tuple currTuple = queue.poll();
                Node currNode = currTuple.root;
                int id = currTuple.id;
                if(i == 0)  startId = id;
                if(i == size - 1) lastId = id;

                if(currNode.left != null)
                    queue.add(new Tuple(currNode.left, (id  - 1) * 2)); // We are subtracting it because to prevent overflow as the no. of nodes at each level can increase exponentially

                if(currNode.right != null)
                    queue.add(new Tuple(currNode.right, (id - 1) * 2 + 1));
            }
            maxWidth = Math.max(maxWidth, lastId - startId + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(widthOfBinaryTree(root));
    }
}
