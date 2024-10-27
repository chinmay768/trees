public class TransformBinaryTreeToDoubleLinkedList {

    public static void traverseLinkedList(Node head) {
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.right;
        }
    }

    public static Node prev, head;

    public static void convertToLinkedList(Node root){
        if(root == null){
            return;
        }

        convertToLinkedList(root.left);

        if(prev ==  null){
            head = root;
        }else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToLinkedList(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left =  new Node(6);
        root.right.right = new Node(7);

        convertToLinkedList(root);

        traverseLinkedList(head);
    }
}
