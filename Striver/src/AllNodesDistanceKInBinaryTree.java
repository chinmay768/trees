import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    private void markParents(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node currNode = queue.poll();

            if(currNode.left != null){
                parentMap.put(currNode.left, currNode);
                queue.add(currNode.left);
            }

            if(currNode.right != null){
                parentMap.put(currNode.right, currNode);
                queue.add(currNode.right);
            }
        }
    }

    private List<Integer> distanceK(Node root, Node target, int k){
        Map<Node, Node> parentMap = new HashMap<>();
        markParents(root, parentMap);
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int dist = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if(dist == k) break; // At dist == k your queue will contain the nodes at K dist
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();

                if(parentMap.get(currNode) != null && !visited.contains(parentMap.get(currNode))){
                    queue.offer(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }

                if(currNode.left != null && !visited.contains(currNode.left)){
                    queue.offer(currNode.left);
                    visited.add(currNode.left);
                }

                if(currNode.right != null && !visited.contains(currNode.right)){
                    queue.offer(currNode.right);
                    visited.add(currNode.right);
                }
            }

            dist++; // After processing a level increment dist
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            result.add(currNode.data);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
