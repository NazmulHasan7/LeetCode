// 145. Binary Tree Postorder Traversal
package Easy;
import java.util.*;

public class Easy_145_Binary_Tree_Postorder_Traversal {
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
    public static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> answer = new LinkedList<>();
        if(root == null) return answer;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // Add at the front as [queue]
            answer.addFirst(node.val);

            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        } return answer;
    }
    public static List<Integer> postOrderTraversalBetter(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postOrder(root, answer);
        return answer;
    }
    public static void postOrder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        postOrder(root.left, arr);
        postOrder(root.right, arr);
        arr.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root = insertIntoBST(root, num);

        List<Integer> answer = postOrderTraversal(root);
        System.out.println(Arrays.toString(answer.toArray()));
        answer = postOrderTraversal(root);
        System.out.println(Arrays.toString(answer.toArray()));
        answer = postOrderTraversal(root);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
