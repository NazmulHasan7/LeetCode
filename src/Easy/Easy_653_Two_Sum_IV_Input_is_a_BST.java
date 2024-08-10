// 653. Two Sum IV - Input is a BST
package Easy;
import java.util.HashSet;
import java.util.Stack;

public class Easy_653_Two_Sum_IV_Input_is_a_BST {
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
    public static boolean findTargetIterative(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (set.contains(k - current.val))
                return true;

            set.add(current.val);
            current = current.right;
        } return false;
    }
    static HashSet<Integer> set = new HashSet<>();
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        int[] arr = new int[]{3,6,2,4,-1,8,1,-1,-1,-1,7,9};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(findTarget(root, 17));
        System.out.println(findTarget(root, 20));
    }
}
