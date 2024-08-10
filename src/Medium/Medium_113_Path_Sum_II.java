// 113. Path Sum II
package Medium;
import java.util.List;
import java.util.ArrayList;

public class Medium_113_Path_Sum_II {
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
    private static List<List<Integer>> answer = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null)
            dfs(root, targetSum, new ArrayList<>(), 0);
        return answer;
    }
    private static void dfs(TreeNode root, int target, List<Integer> currentPath, int currentSum) {
        if (root == null) return;
        currentSum += root.val;
        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == target)
                answer.add(new ArrayList<>(currentPath));
        }
        dfs(root.left, target, currentPath, currentSum);
        dfs(root.right, target, currentPath, currentSum);
        currentPath.removeLast();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(pathSum(root, 14));
    }
}
