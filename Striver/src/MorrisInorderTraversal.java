import java.util.*;
public class MorrisInorderTraversal {

    public static List<Integer> morrisInorderTraversal(Node root){
        List<Integer> inorder = new ArrayList<>();
        Node curr = root;

        while (curr != null){
            if(curr.left == null){
                inorder.add(curr.data);
                curr = curr.right;
            }else {
                Node rightMostInLeft = curr.left; // This node will represent inorder predecessor
                while (rightMostInLeft.right != null && rightMostInLeft.right != curr)
                    rightMostInLeft = rightMostInLeft.right;

                if(rightMostInLeft.right == null){
                    rightMostInLeft.right = curr;
                    curr = curr.left;
                }else {
                    rightMostInLeft.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(morrisInorderTraversal(root));
    }
}
