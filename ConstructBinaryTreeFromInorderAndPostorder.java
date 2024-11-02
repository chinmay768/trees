import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorder {

    public static Node buildTree(int[] inorder, int[] postorder){
        if(inorder ==  null || postorder == null ||  inorder.length != postorder.length)  return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private static Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map){
        if(inStart > inEnd || postStart > postEnd) return null;

        Node root = new Node(postorder[postEnd]);

        int inRootIdx = map.get(postorder[postEnd]);
        int leftNumsCount = inRootIdx - inStart;

        root.left = buildTree(inorder, inStart, inRootIdx - 1, postorder, postStart, postStart + leftNumsCount - 1, map);
        root.right = buildTree(inorder, inRootIdx + 1, inEnd, postorder, postStart + leftNumsCount, postEnd - 1, map);

        return root;
    }

    static void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }


    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        Node root = buildTree(in, post);

        buildTree(in, post);

        printPostorder(root);
    }
}
