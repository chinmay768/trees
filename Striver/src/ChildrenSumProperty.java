public class ChildrenSumProperty {

    public static void modifyToChildSumTree(Node root){
        if(root == null) return;

        int childSum = 0;
        if(root.left != null) childSum += root.left.data;
        if(root.right != null) childSum += root.right.data;

        // To handle the cases where the root is greater than sum of both child bc while backtracking we cannot reduce the root value
        if(root.data > childSum){
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        modifyToChildSumTree(root.left);
        modifyToChildSumTree(root.right);

        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;
        // Added this condition to ignore leaf nodes
        if(root.left != null || root.right != null) root.data = total;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        modifyToChildSumTree(root);

        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));
    }
}
