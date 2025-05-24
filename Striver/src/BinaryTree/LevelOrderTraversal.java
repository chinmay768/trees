package BinaryTree;

import java.util.*;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;

        queue.add(root);
        while (!queue.isEmpty()){
            int currSize = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < currSize; i++){
                Node currNode = queue.poll();

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);

                curr.add(currNode.data);
            }
            levelOrder.add(curr);
        }

        return levelOrder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(levelOrderTraversal(root));
    }
}
