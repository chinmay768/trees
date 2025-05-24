package BinaryTree;

import java.util.*;
public class BottomViewOfBinaryTree {

    static class Tuple {
        Node node;
        int hd;

        Tuple(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> bottomView(Node root){
        List<Integer> bottomView = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        if(root == null) return bottomView;
        queue.add(new Tuple(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Tuple currTuple = queue.poll();
                Node currNode = currTuple.node;
                int hd = currTuple.hd;
                map.put(hd, currNode.data);

                if(currNode.left != null) queue.add(new Tuple(currNode.left, hd - 1));
                if(currNode.right != null) queue.add(new Tuple(currNode.right, hd + 1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            bottomView.add(entry.getValue());
        }

        return bottomView;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(bottomView(root));
    }
}
