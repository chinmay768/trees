import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RootToLeafPaths {

    public static void rootToLeafPathsPassByValue(Node root, List<List<Integer>> paths, List<Integer> currPath){
        if(Objects.isNull(root)){
            return;
        }

        currPath.add(root.data);

         if(root.left == null && root.right == null){
             paths.add(new ArrayList<>(currPath));
         }

         rootToLeafPaths(root.left, paths, new ArrayList<>(currPath));
         rootToLeafPaths(root.right, paths, new ArrayList<>(currPath));
    }

    public static void findRootToLeafPaths(Node root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        rootToLeafPathsPassByValue(root, paths, currPath);
        System.out.println(paths);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        findRootToLeafPaths(root);
    }
}
//      1
//   2      3
//4     5 6     7