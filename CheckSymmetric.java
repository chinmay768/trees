public class CheckSymmetric {

    public static boolean checkMirror(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        return checkMirror(root1.left, root2.right) && checkMirror(root1.right, root2.left);
    }

    public static boolean isSymmetric(Node root){
        if(root == null)
            return true;
        return checkMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right.left = new Node(4);
        root1.right.right = new Node(3);

        System.out.println(isSymmetric(root1));
    }
}
