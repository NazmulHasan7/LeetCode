// 429. N-ary Tree Level Order Traversal
package Medium;
import java.util.*;

public class Medium_429_N_ary_Tree_Level_Order_Traversal {
    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) { val = _val; }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                Node current = queue.poll();
                for (Node child : current.children)
                    queue.add(child);
                level.add(current.val);
            }
            answer.add(level);
        } return answer;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = new ArrayList<>(Arrays.asList(node2, node3, node4));
        node3.children = new ArrayList<>(Arrays.asList(node5, node6));
        System.out.println(levelOrder(node1));
    }
}
