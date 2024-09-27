public class RootToLeafMaxSum {

     public static int rootToLeafMaxSum(Node root){
         if(root == null){
             return 0;
         }

         if(root.left == null && root.right == null){
             return root.data;
         }

         int maxSumLeft = 0;
         if(root.left != null){
             maxSumLeft = rootToLeafMaxSum(root.left);
         }

         int maxSumRight = 0;
         if(root.right != null){
             maxSumRight = rootToLeafMaxSum(root.right);
         }

         return Math.max(maxSumLeft + root.data, maxSumRight + root.data);
     }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(rootToLeafMaxSum(root));
    }
}

//      1
//   2      3
//4     5 6     7
