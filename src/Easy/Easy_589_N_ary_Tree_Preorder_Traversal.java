// 589. N-ary Tree Preorder Traversal
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_589_N_ary_Tree_Preorder_Traversal {
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
    private static void dfs(Node root, List<Integer> answer) {
        if (root == null) return;
        answer.add(root.val);

        for (Node child : root.children)
            dfs(child, answer);
    }
    public static List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, answer);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(preorder(new Node(1)));
    }
}
