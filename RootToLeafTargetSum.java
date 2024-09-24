import java.util.Objects;

public class RootToLeafTargetSum {

    public static Boolean checkSumExists(Node root, int targetSum, int currSum){
        if(Objects.isNull(root))
            return false;

        currSum += root.data;

        if(Objects.isNull(root.left) && Objects.isNull(root.right) && currSum == targetSum){
            return true;
        }

        Boolean sumExistsOnLeft = checkSumExists(root.left, targetSum, currSum);
        Boolean sumExistsOnRight = checkSumExists(root.right, targetSum, currSum);

//        if(sumExistsOnLeft || sumExistsOnRight){
//            return true;
//        }else{
//            return false;
//        }

        return sumExistsOnLeft || sumExistsOnRight;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int targetSum = 11;

        System.out.println(checkSumExists(root, targetSum, 0));
    }
}
