import java.util.Objects;
import java.util.Stack;

public class ZigZagTraversal {

    public static void zigzagTraversal(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while (!s1.isEmpty()){
                Node curr = s1.pop();
                System.out.println(curr.data);
                if(curr.right != null){
                    s2.push(curr.right);
                }
                if(curr.left != null){
                    s2.push(curr.left);
                }
            }


            while (!s2.isEmpty()){
                Node curr = s2.pop();
                System.out.println(curr.data);
                if(curr.left != null){
                    s1.push(curr.left);
                }
                if(curr.right != null){
                    s1.push(curr.right);
                }
            }
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


        zigzagTraversal(root);
    }
}
