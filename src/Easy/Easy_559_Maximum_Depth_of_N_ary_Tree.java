// 559. Maximum Depth of N-ary Tree
package Easy;
import java.util.List;

public class Easy_559_Maximum_Depth_of_N_ary_Tree {
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
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        int height = 0;
        for (Node neighbor : root.children)
            height = Math.max(height, maxDepth(neighbor));
        return height + 1;
    }
    public static void main(String[] args) {
        System.out.println(maxDepth(new Node(1)));
    }
}
