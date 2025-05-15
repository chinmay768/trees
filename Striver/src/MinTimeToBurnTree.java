import java.util.*;

public class MinTimeToBurnTree {
// Leetcode: 2385. Amount of Time for Binary Tree to Be Infected
    private static Node mapParents(Node root, Map<Node, Node> parentMap, int start){
        Node targetNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode.data == start) targetNode = currNode;

            if(currNode.left != null){
                parentMap.put(currNode.left, currNode);
                queue.add(currNode.left);
            }

            if(currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                queue.add(currNode.right);
            }
        }
//        parentMap.forEach((key, value) -> System.out.println(key.data + " " + value.data));
        return targetNode;
    }

    private static int findMaxDistance(Node startNode, Map<Node, Node> parentMap){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        Set<Node> visited = new HashSet<>();
        visited.add(startNode);
        int time = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            int flag = 0; // This flags denotes that new nodes were added
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();

                if(currNode.left != null && !visited.contains(currNode.left)){
                    flag = 1;
                    queue.offer(currNode.left);
                    visited.add(currNode.left);
                }

                if(currNode.right != null && !visited.contains(currNode.right)){
                    flag = 1;
                    queue.offer(currNode.right);
                    visited.add(currNode.right);
                }

                if(parentMap.get(currNode) != null && !visited.contains(parentMap.get(currNode))){
                    flag = 1;
                    queue.offer(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }
            }

            if(flag == 1) time++;
        }

        return time;
    }

    public static int timeToBurnTree(Node root, int start){
        Map<Node, Node> parentMap = new HashMap<>();
        Node startNode = mapParents(root, parentMap, start);
        int maxTime = findMaxDistance(startNode, parentMap);
        return maxTime;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(timeToBurnTree(root, 3));

    }
}
