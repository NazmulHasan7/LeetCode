// 513. Find Bottom Left Tree Value
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_513_Find_Bottom_Left_Tree_Value {
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
    public static int findBottomLeftValue(TreeNode root) {
        int leftValue = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            leftValue = queue.peek().val;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        } return leftValue;
    }
    static int maxDepth = -1, answer = -1;
    public static int findBottomLeftValueDFS(TreeNode root) {
        dfs(root, 0);
        return answer;
    }
    private static void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth > maxDepth) {
            maxDepth = depth;
            answer = root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(findBottomLeftValue(root));
    }
}
