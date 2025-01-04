// 117. Populating Next Right Pointers in Each Node II
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_117_Populating_Next_Right_Pointers_in_Each_Node_II {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        public Node(int _val) { val = _val; }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            Node prev = null;
            while (n-- > 0) {
                Node current = queue.poll();
                if (prev != null) prev.next = current; // points to current node as the next node
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                prev = current;
            }
            prev.next = null; // right most points to null as next
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        System.out.println(connect(root).val);
    }
}
