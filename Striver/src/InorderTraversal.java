import java.util.*;

public class InorderTraversal {

    public static void inorderRecursive(Node root) {
        if (root == null) {
            return;
        }

        inorderRecursive(root.left);
        System.out.println(root.data);
        inorderRecursive(root.right);
    }

    public static void inorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return;

        while (root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }else {
                Node topNode = st.pop();
                list.add(topNode.data);
                root = topNode.right;
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inorderIterative(root);
    }
}
