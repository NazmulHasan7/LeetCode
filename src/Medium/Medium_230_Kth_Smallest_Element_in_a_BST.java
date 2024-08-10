// 230. Kth Smallest Element in a BST
package Medium;
import java.util.Stack;

public class Medium_230_Kth_Smallest_Element_in_a_BST {
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
    public static int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (++count == k)
                return current.val;
            current = current.right;
        }
        return -1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        int[] arr = new int[]{1,4,100,2};
        for (int a : arr)
            insertIntoBST(root, a);
        System.out.println(kthSmallest(root, 3));
    }
}
