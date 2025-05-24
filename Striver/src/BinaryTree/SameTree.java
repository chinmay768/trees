package BinaryTree;

public class SameTree {

    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        boolean checkLeft = isSameTree(p.left, q.left);
        boolean checkRight = isSameTree(p.right, q.right);

        return (p.data == q.data) && checkLeft && checkRight;
    }

    public static void main(String[] args) {

    }
}
