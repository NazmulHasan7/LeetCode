// 1161. Maximum Level Sum of a Binary Tree
package Medium;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Medium_1161_Maximum_Level_Sum_of_a_Binary_Tree {
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
    public static int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, maxLevel = -1;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        } return maxLevel;
    }
    static int max = Integer.MIN_VALUE;
    static int answer = 0;
    static List<Integer> arr = new ArrayList<>();
    public static int maxLevelSumDFS(TreeNode root) {
        dfs(root, 0);
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
                answer = i + 1;
            }
        } return answer;
    }
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (arr.size() == level) arr.add(0);

        int sum = arr.get(level) + root.val;
        arr.set(level, sum);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(maxLevelSum(root));
        System.out.println(maxLevelSumDFS(root));
    }
}
