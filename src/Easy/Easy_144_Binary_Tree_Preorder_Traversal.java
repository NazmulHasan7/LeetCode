// 144. Binary Tree Preorder Traversal
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Easy_144_Binary_Tree_Preorder_Traversal {
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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preOrder(root, answer);
        return answer;
    }
    public static void preOrder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        // Since the parent is already visited before going to the left
        // push right node to the stack even if the right is null
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                answer.add(current.val);
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
            }
        } return answer;
    }
    public static List<Integer> preorderTraversalIterativeEasy(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        stack.push(root);

        while (!stack.isEmpty()) {
            // root is visited
            root = stack.pop();
            answer.add(root.val);
            // Push Right element first then left
            // So that on pop operation we have left element accessed first
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        } return answer;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root = insertIntoBST(root, num);

        List<Integer> answer = preorderTraversal(root);
        System.out.println(Arrays.toString(answer.toArray()));
        answer = preorderTraversalIterative(root);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
