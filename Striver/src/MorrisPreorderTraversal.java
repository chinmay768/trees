import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    // First do the inorder morris traversal
    public static List<Integer> morrisPreorderTraversal(Node root){
        List<Integer> preorder = new ArrayList<>();
        Node curr = root;

        while (curr != null){
            if(curr.left == null){
                preorder.add(curr.data);
                curr = curr.right;
            }else {
                Node rightMostInLeft = curr.left; // This node will represent inorder predecessor
                while (rightMostInLeft.right != null && rightMostInLeft.right != curr)
                    rightMostInLeft = rightMostInLeft.right;

                if(rightMostInLeft.right == null){
                    rightMostInLeft.right = curr;
                    preorder.add(curr.data); // We have shifted this line to here to add it in the list before moving to left
                    curr = curr.left;
                }else {
                    rightMostInLeft.right = null;
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(morrisPreorderTraversal(root));
    }
}
