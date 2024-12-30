// 437. Path Sum III
package Medium;
import java.util.HashMap;

public class Medium_437_Path_Sum_III {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // Brute Force Approach -> Similar to Path Sum problem
    // Try every node as the root node and count the paths
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int pathsFromRoot = countPaths(root, targetSum, 0);
        int pathsFromLeftChild = pathSum(root.left, targetSum);
        int pathsFromRightChild = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeftChild + pathsFromRightChild;
    }
    private static int countPaths(TreeNode root, int targetSum, long currentSum) {
        if (root == null) return 0;

        currentSum += root.val;
        int count = 0;
        if (currentSum == targetSum) count++;

        return count + countPaths(root.left, targetSum, currentSum)
                + countPaths(root.right, targetSum, currentSum);
    }

    // Optimized Approach
    public static int pathSumOpt(TreeNode root, int targetSum) {
        // HashMap to store prefix sum frequencies
        HashMap<Long, Integer> map = new HashMap<>();
        // Base case: single path from root with sum = 0
        map.put(0L, 1);
        return solve(root, (long) targetSum, 0L, map);
    }
    private static int solve(TreeNode node, long targetSum, long currentSum, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        // Update the current sum
        currentSum += node.val;
        // Calculate the number of valid paths that end at the current node
        int numPaths = map.getOrDefault(currentSum - targetSum, 0);
        // Add the current sum to the prefix sum count
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        // Recurse for left and right subtrees
        numPaths += solve(node.left, targetSum, currentSum, map);
        numPaths += solve(node.right, targetSum, currentSum, map);

        // Backtrack: remove the current sum from the prefix sum count
        map.put(currentSum, map.get(currentSum) - 1);
        return numPaths;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        System.out.println(pathSum(root, 8));
    }
}
