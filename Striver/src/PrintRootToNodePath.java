import java.util.*;
public class PrintRootToNodePath {

    public static boolean getPath(Node root, int target, List<Integer> path){
        if(root == null) return false;

        path.add(root.data);
        if(root.data == target) return true;

        if(getPath(root.left, target, path) || getPath(root.right, target, path)){
            return true;
        }
        path.removeLast();
        return false;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        List<Integer> path = new ArrayList<>();

        getPath(root, 9, path);
        System.out.println(path);
    }
}
