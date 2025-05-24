package BinaryTree;

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

    static class Tuple2{
        Node node;
        Integer col;
        Integer level;
        Tuple2(Node node, Integer col, Integer level){
            this.node = node;
            this.col = col;
            this.level = level;
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

    public static List<List<Integer>> verticalTraversalSameLevelAndColSorted(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Map<Integer, Queue<Integer>>>  map = new TreeMap<>();
        Queue<Tuple2> queue = new LinkedList<>();

        if(root == null) return result;
        queue.offer(new Tuple2(root, 0, 0));

        while (!queue.isEmpty()){
            Tuple2 currTuple = queue.poll();
            Node currNode = currTuple.node;
            int col = currTuple.col;
            int level = currTuple.level;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(level, new PriorityQueue<>());

            map.get(col).get(level).add(currNode.data);
            if(currNode.left != null) queue.offer(new Tuple2(currNode.left, col - 1, level + 1));
            if(currNode.right != null) queue.offer(new Tuple2(currNode.right, col + 1, level + 1));
        }

        for(Map<Integer, Queue<Integer>> entry: map.values()){
            result.add(new ArrayList<>());
            for(Queue<Integer> nodes : entry.values()){
                while (!nodes.isEmpty()){
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
