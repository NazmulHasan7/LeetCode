// 590. N-ary Tree Postorder Traversal
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_590_N_ary_Tree_Postorder_Traversal {
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

        for (Node child : root.children)
            dfs(child, answer);
        answer.add(root.val);
    }
    public static List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        dfs(root, answer);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(postorder(new Node(1)));
    }
}
