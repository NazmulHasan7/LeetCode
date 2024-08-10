// 1302. Deepest Leaves Sum
package Medium;
import java.util.Queue;
import java.util.LinkedList;

public class Medium_1302_Deepest_Leaves_Sum {
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
    public static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right==null)
                    levelSum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            sum = levelSum;
        } return sum;
    }
    static int maxHeight = 0, height = 0, sum = 0;
    public static int deepestLeavesSumRecursive(TreeNode root) {
        inorderDFS(root,height);
        return sum;
    }
    private static void inorderDFS(TreeNode root, int height) {
        if (root == null) return;
        height++;

        inorderDFS(root.left, height);
        if (root.left == null && root.right == null) {
            if (height > maxHeight) {
                sum = root.val;
                maxHeight = height;
            } else if (height == maxHeight) {
                sum += root.val;
            }
        }
        inorderDFS(root.right, height);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        System.out.println(deepestLeavesSum(root));
        System.out.println(deepestLeavesSumRecursive(root));
    }
}
