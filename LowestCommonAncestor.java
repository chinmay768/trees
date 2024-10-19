public class LowestCommonAncestor {

    static boolean v1 , v2;

    //This assumes that the keys are present
    public static Node lca(Node root, int  num1, int num2){
        if(root == null)
            return null;

        if(root.data == num1 || root.data == num2)
            return root;

        Node leftLca = lca(root.left, num1, num2);
        Node rightLca = lca(root.right, num1, num2);

        if(leftLca != null && rightLca != null)
            return root;

        return (leftLca != null)? leftLca  : rightLca;
    }

    //This don't assume that the keys are present
    public static Node lca2(Node root, int num1, int num2){
        if(root == null)
            return null;

        Node temp = null;

        if(root.data == num1){
            v1 = true;
            temp  = root;
        }

        if(root.data == num2){
            v2 = true;
            temp = root;
        }

        Node leftLca = lca2(root.left, num1, num2);
        Node rightLca = lca2(root.right, num1, num2);

        if(temp != null)
            return temp;

        if(leftLca != null && rightLca != null) {
            return root;
        }

        return (leftLca != null)? leftLca : rightLca;

    }

    public static void main(String[] args) {
        Node root1 = new Node(22);
        root1.left = new Node(6);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.left.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(4);

        System.out.println(lca(root1, 3,  9));

        if(v1 && v2){
            System.out.println(lca2(root1, 3, 9));
        }else {
            System.out.println("LCA not found!");
        }

    }
}
