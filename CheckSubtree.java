import java.util.LinkedList;
import java.util.Queue;

public class CheckSubtree {

    public static Boolean checkTwoBinaryTreesIdentical(Node  root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.data != root2.data){
            return  false;
        }

        return checkTwoBinaryTreesIdentical(root1.left, root2.left) && checkTwoBinaryTreesIdentical(root1.right, root2.right);

    }

    public static boolean checkSubtree(Node root1, Node root2){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root1);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.data == root2.data){
                if(checkTwoBinaryTreesIdentical(curr, root2)) return true;
            }

            if(curr.left != null)
                queue.offer(curr.left);
            if(curr.right != null)
                queue.offer((curr.right));
        }

        return false;
    }



    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);


        Node root2 = new Node(3);
        root2.left = new Node(6);
        root2.right = new Node(8);


        System.out.println(checkSubtree(root1, root2));
    }
}
