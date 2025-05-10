import java.util.*;

public class BoundaryTraversal {

    public static boolean isLeafNode(Node root){
        if(root.left == null && root.right == null) return true;
        else return false;
    }

    public static List<Integer> leftBoundary(Node root){
        List<Integer> leftList = new ArrayList<>();
        Node curr = root;
        while (curr != null){
            if(!isLeafNode(curr)) leftList.add(curr.data);
            if(curr.left != null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }

        return leftList;
    }

    public static List<Integer> rightBoundary(Node root){
        List<Integer> rightList = new ArrayList<>();
        Node curr = root;
        while (curr != null){
            if(!isLeafNode(curr)) rightList.addFirst(curr.data);
            if(curr.right != null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }

        return rightList;
    }

    public static void bottomBoundary(Node root, List<Integer> nodes){
        if(isLeafNode(root)){
            nodes.add(root.data);
            return;
        }

        if(root.left != null) bottomBoundary(root.left, nodes);
        if(root.right != null) bottomBoundary(root.right, nodes);

    }

    public static List<Integer> printBoundary(Node root){
        // Anti-clockwise
        List<Integer> boundary = new ArrayList<>();
        if(root != null) boundary.add(root.data);

        List<Integer> leftBoundary = leftBoundary(root.left);
        List<Integer> bottomBoundary = new ArrayList<>();
        bottomBoundary(root, bottomBoundary);
        List<Integer> rightBoundary = rightBoundary(root.right);

        boundary.addAll(leftBoundary);
        boundary.addAll(bottomBoundary);
        boundary.addAll(rightBoundary);
        return boundary;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(printBoundary(root));
    }
}
