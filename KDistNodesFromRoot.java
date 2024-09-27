import java.util.ArrayList;
import java.util.List;

public class KDistNodesFromRoot {

    public static void kDistNodesFromRoot(Node root, int dist, List<Integer> nodes){
        if(root == null){
            return;
        }

        if(dist == 0){
            nodes.add(root.data);
        }

        kDistNodesFromRoot(root.left, dist - 1, nodes);
        kDistNodesFromRoot(root.right, dist - 1, nodes);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        List<Integer> nodes = new ArrayList<>();
        kDistNodesFromRoot(root, 2, nodes);
        System.out.println(nodes);
    }
}
