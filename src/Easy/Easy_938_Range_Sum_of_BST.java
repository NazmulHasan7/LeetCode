// 938. Range Sum of BST
package Easy;
import java.util.Stack;

public class Easy_938_Range_Sum_of_BST {
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
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
    public static int rangeSumBSTIterative(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val >= low && node.val <= high)
                sum += node.val;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        int[] arr = new int[]{5,15,3,7,-1,18};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(rangeSumBST(root,7,15));
        System.out.println(rangeSumBSTIterative(root,7,15));
    }
}
