public class DistanceBwTwoNodes {

    public static int dist(Node root, int k, int level){
        if(root == null)
            return -1;

        if(root.data == k)
            return level;

        int leftLevel = dist(root.left, k, level + 1);
        if(leftLevel == -1)
            return dist(root.right, k, level + 1);

        return leftLevel;
    }

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

    public static int distanceBwTwoNodes(Node root, int a, int b){
        Node lca = lca(root, a, b);

        int d1 =  dist(lca, a, 0);
        int d2 = dist(lca, b, 0);

        return  d1 + d2;
    }

    public static void main(String[] args) {
        Node root1 = new Node(22);
        root1.left = new Node(6);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.left.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(4);

        System.out.println(distanceBwTwoNodes(root1, 3, 4));
    }
}