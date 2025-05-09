import java.util.*;
public class VerticalOrderTraversal {

    class Tuple{
        Node node;
        Integer col;
        Tuple(Node node, Integer col){
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> verticalList = new ArrayList<>();
        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        if(root == null) return verticalList;
        queue.add(new Tuple(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Tuple currTuple = queue.poll();
                Node currNode = currTuple.node;
                Integer col = currTuple.col;
                verticalMap.putIfAbsent(col, new ArrayList<>());
                verticalMap.get(col).add(currNode.data);

                if(currNode.left != null) queue.add(new Tuple(currNode.left, col - 1));
                if (currNode.right != null) queue.add(new Tuple(currNode.right, col + 1));
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry : verticalMap.entrySet()){
//                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            verticalList.add(entry.getValue());
        }
        return verticalList;
    }

    public static void main(String[] args) {

    }
}
