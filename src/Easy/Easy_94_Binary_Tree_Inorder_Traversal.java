// 94. Binary Tree Inorder Traversal
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Easy_94_Binary_Tree_Inorder_Traversal {
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
    public static void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inOrder(root, answer);
        return answer;
    }
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        TreeNode current = root;
        // Keep going to the left and push to the stack till it reaches null
        // When there is no left, pop parent from stack and go to the right
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            answer.add(current.val);
            current = current.right;
        } return answer;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root = insertIntoBST(root, num);

        List<Integer> answer = inorderTraversal(root);
        System.out.println(Arrays.toString(answer.toArray()));
        answer = inorderTraversalIterative(root);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
