import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreorder {

    public static Node buildTree(int[] preOrder, int preOrderStart, int preOrderend, int[] inOrder, int inOrderStart, int inorderEnd, Map<Integer, Integer> inMap){
        if(preOrderStart > preOrderend || inOrderStart > inorderEnd) return null;

        Node root = new Node(preOrder[preOrderStart]);

        int inRootIdx = inMap.get(root.data);
        int numsLeftCount =  inRootIdx - inOrderStart;

        root.left = buildTree(preOrder, preOrderStart + 1, preOrderStart + numsLeftCount, inOrder, inOrderStart, inRootIdx - 1, inMap);
        root.right = buildTree(preOrder, preOrderStart + numsLeftCount + 1, preOrderend, inOrder, inRootIdx + 1, inorderEnd, inMap);

        return root;
    }

    public static Node buildTree(int[] in, int[] pre){
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < in.length; i++){
            inMap.put(in[i], i);
        }

        Node root = buildTree(pre, 0, pre.length - 1, in,  0, in.length - 1, inMap);

        return root;
    }

    static void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }


    public static void main(String[] args) {
        int[] in = {3, 1, 4, 0, 5, 2};
        int[] pre = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(in, pre);

        printPostorder(root);
    }
}
