import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static String serialize(Node root){
        if(root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode == null) {
                sb.append("# ");
                continue;
            }

            sb.append(currNode.data + " ");

            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }

        return sb.toString();
    }

    public static Node deserialize(String str){
        if (str == "") return null;

        Queue<Node> queue = new LinkedList<>();
        String[] values = str.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i = 1; i < values.length; i++){
            Node currNode = queue.poll();

            if(!values[i].equals("#")){
                currNode.left = new Node(Integer.parseInt(values[i]));
                queue.add(currNode.left);
            }

            i++;
            if(!values[i].equals("#")){
                currNode.right = new Node(Integer.parseInt(values[i]));
                queue.add(currNode.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        String str = serialize(root);
        Node root2 = deserialize(str);

        System.out.println(LevelOrderTraversal.levelOrderTraversal(root2));
    }
}
