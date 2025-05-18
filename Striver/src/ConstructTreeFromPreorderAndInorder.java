import java.util.*;

public class ConstructTreeFromPreorderAndInorder {

    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1, inMap);

        return root;
    }

    public static Node buildTree(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd,
                                 Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);

        int inorderRootIdx = inMap.get(preorder[preStart]);
        int leftElmsCount = inorderRootIdx - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftElmsCount,
                inorder, inStart, inorderRootIdx - 1, inMap);

        root.right = buildTree(preorder, preStart + leftElmsCount + 1, preEnd,
                inorder, inorderRootIdx + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] preOrder = {3, 9, 20, 15, 7};

        System.out.println(LevelOrderTraversal.levelOrderTraversal(buildTree(preOrder, inOrder)));
    }

}
