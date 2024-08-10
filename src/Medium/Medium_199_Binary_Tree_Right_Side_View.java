// 199. Binary Tree Right Side View
package Medium;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Medium_199_Binary_Tree_Right_Side_View {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){this.val = value;}
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (val <= root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer.add(queue.getLast().val);

            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        } return answer;
    }
    static List<Integer> answer = new ArrayList<>();
    public static List<Integer> rightSideViewDFS(TreeNode root) {
        if (root == null) return answer;
        dfs(root, 0);
        return answer;
    }
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == answer.size())
            answer.add(root.val);

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(rightSideView(root));
    }
}
