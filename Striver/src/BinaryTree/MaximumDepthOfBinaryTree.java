package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    // Height of Binary Tree

    public static int heightUisngLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();

        if(root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();
                curr.add(currNode.data);
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            levelOrder.add(curr);
        }
        System.out.println(levelOrder);
        return levelOrder.size();
    }

    public static int heightUsingRecursion(Node root){
        if(root == null) return 0;

        int lh = heightUsingRecursion(root.left);
        int rh = heightUsingRecursion(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {

    }
}
