package BinarySearchTree;

import BinaryTree.Node;

public class LCAInBST {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        int curr = root.data;
        if(curr < p.data && curr < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.data && curr > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}
