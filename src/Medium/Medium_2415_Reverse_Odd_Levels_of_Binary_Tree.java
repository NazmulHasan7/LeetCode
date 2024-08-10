// Medium 2415. Reverse Odd Levels of Binary Tree
package Medium;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;

public class Medium_2415_Reverse_Odd_Levels_of_Binary_Tree {
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
    public static int height = 0;
    public static TreeNode reverseOddLevels(TreeNode root) {
        reverseOdd(root.left, root.right, height);
        return root;
    }
    private static void reverseOdd(TreeNode left, TreeNode right, int height) {
        if (left == null || right == null) return;
        height++;
        if (height % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverseOdd(left.left, right.right, height);
        reverseOdd(left.right, right.left, height);
    }
    public static TreeNode reverseOddLevelsBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> nodeValues = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    // Since perfect binary tree
                    queue.add(node.left);
                    nodeValues.add(node.left.val);
                    queue.add(node.right);
                    nodeValues.add(node.right.val);
                }
            }
            level++;
            if (level % 2 != 0) {
                int index = 0;
                Collections.reverse(nodeValues);
                for (TreeNode node : queue)
                    node.val = nodeValues.get(index++);
            }
        } return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root = reverseOddLevelsBFS(root);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
