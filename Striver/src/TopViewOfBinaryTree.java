import java.util.*;

public class TopViewOfBinaryTree {

    static class Pair{
        Node node;
        int hd;

        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(Node root){
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> topView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        if(root == null) return topView;
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Pair currPair = queue.poll();
                Node currNode = currPair.node;
                int hd = currPair.hd;

                if(currNode.left != null) queue.add(new Pair(currNode.left, hd - 1));
                if(currNode.right != null) queue.add(new Pair(currNode.right, hd + 1));

                map.putIfAbsent(hd, currNode.data);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int hd = entry.getKey();
            int data = entry.getValue();

            topView.add(data);
        }
        return topView;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(topView(root));
    }
}
