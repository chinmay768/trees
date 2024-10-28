public class TransformLeavesToDoublyLinkedList {
    public static Node head;
    public static Node tail;

    public static Node transformToDLL(Node root){
        if(root == null){
            return null;
        }

        root.left = transformToDLL(root.left);

        if(root.left == null && root.right == null){
            if(head == null){
                head = root;
            }else {
                root.left = tail;
                tail.right = root;
            }
            tail = root;
            return null;
        }

        root.right = transformToDLL(root.right);

        return root;
    }

    public static void printDLL(Node head){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.right;
        }
    }

    public static void preorderTraversal(Node root) {
        if(root == null)
            return;

        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left =  new Node(6);
        root.right.right = new Node(7);

        transformToDLL(root);

        preorderTraversal(root);

        System.out.println("----------------");
        printDLL(head);
    }
}
