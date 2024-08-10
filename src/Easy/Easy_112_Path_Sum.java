// 112. Path Sum
package Easy;
import java.util.Queue;
import java.util.LinkedList;

public class Easy_112_Path_Sum {
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
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        int currentSum = 0;
        return hasPathSum(root, targetSum, currentSum);
    }
    private static boolean hasPathSum(TreeNode root, int target, int currentSum) {
        if (root == null) return false;
        currentSum += root.val;
        if (root.left == null && root.right == null)
            return currentSum == target;
        return hasPathSum(root.left, target, currentSum) || hasPathSum(root.right, target, currentSum);
    }
    public static boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        queue.add(root);
        sum.add(root.val);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                int currentSum = sum.poll();

                if (node.left == null && node.right == null && currentSum == targetSum)
                    return true;

                if (node.left != null) {
                    queue.add(node.left);
                    sum.add(node.left.val + currentSum);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum.add(node.right.val + currentSum);
                }
            }
        } return false;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        System.out.println(hasPathSum(root1, 10));
        System.out.println(hasPathSumBFS(root1, 11));
    }
}
