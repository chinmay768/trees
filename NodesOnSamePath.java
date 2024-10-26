public class NodesOnSamePath {
    static boolean v1 , v2;
    static Boolean flag = true;

    public static Node nodesOnSamePath(Node root, int num1, int num2){
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

        Node leftLca = nodesOnSamePath(root.left, num1, num2);
        Node rightLca = nodesOnSamePath(root.right, num1, num2);

        if(temp != null)
            return temp;

        if(leftLca != null && rightLca != null) {
            flag = false;
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

        nodesOnSamePath(root1, 7,  4);
        System.out.println(flag);
    }
}
