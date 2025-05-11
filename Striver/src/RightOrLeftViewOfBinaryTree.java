import java.util.ArrayList;
import java.util.List;

public class RightOrLeftViewOfBinaryTree {

    public static List<Integer> rightView(Node root){
        List<Integer> rightView = new ArrayList<>();
        rightView(root, rightView, 0);
        return rightView;
    }

    public static void rightView(Node root, List<Integer> rightView, int currDepth){
        if(root == null){
            return;
        }

        if(currDepth == rightView.size()){
            rightView.add(root.data);
        }

        rightView(root.right, rightView, currDepth + 1);
        rightView(root.left, rightView, currDepth + 1);
    }

    public static void leftView(Node root, List<Integer> rightView, int currDepth){
        if(root == null){
            return;
        }

        if(currDepth == rightView.size()){
            rightView.add(root.data);
        }

        rightView(root.left, rightView, currDepth + 1);
        rightView(root.right, rightView, currDepth + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(rightView(root));
    }
}
