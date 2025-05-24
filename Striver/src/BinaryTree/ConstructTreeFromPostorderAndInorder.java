package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostorderAndInorder {

    public static Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        Node root = buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, inMap);

        return root;
    }

    public static Node buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                       int[] postorder, int postStart, int postEnd,
                                       Map<Integer, Integer> inMap) {
        if(inStart > inEnd || postStart > postEnd) return null;

        Node root = new Node(postorder[postEnd]);

        int inorderRootIdx = inMap.get(postorder[postEnd]);
        int leftElmsCount = inorderRootIdx - inStart;

        root.left = buildTreeHelper(inorder, inStart, inorderRootIdx - 1,
                postorder, postStart, postStart + leftElmsCount - 1, inMap);

        root.right = buildTreeHelper(inorder, inorderRootIdx + 1, inEnd,
                postorder, postStart + leftElmsCount, postEnd - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};

        Node root = buildTree(inorder, postorder);
        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));

    }
}
