import java.util.*;
class Tuple {
    Node node;
    int hd;
    Tuple(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalOrderTraversal {
    public static void verticalOrderTraversal(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()){
            Tuple curr = q.poll();
            Node currNode = curr.node;
            int hd = curr.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(currNode.data);

            if(currNode.left != null){
                q.offer(new Tuple(currNode.left, hd - 1));
            }

            if(currNode.right != null){
                q.offer(new Tuple(currNode.right, hd + 1));
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        verticalOrderTraversal(root);
    }
}
