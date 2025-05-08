import java.util.*;

public class ZigZagOrSpiralTraversal {

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if(root == null) return new ArrayList<>();
        queue.add(root);
        Boolean leftToRight = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            Integer[] currList = new Integer[size];
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();

                int idx = leftToRight? i : (size - i - 1);
                currList[idx] = currNode.data;

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            leftToRight = !leftToRight;
            levelOrder.add(Arrays.asList(currList));
        }
        return levelOrder;
    }


    public static void main(String[] args) {

    }
}
