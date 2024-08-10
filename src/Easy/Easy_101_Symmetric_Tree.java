// 101. Symmetric Tree
package Easy;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Easy_101_Symmetric_Tree {
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
    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val) && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    public static boolean isSymmetricBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> nodeValues = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nodeValues.add(null);
                } else {
                    nodeValues.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!checkForSymmetry(nodeValues)) {
                return false;
            }
        } return true;
    }
    private static boolean checkForSymmetry(ArrayList<Integer> array) {
        int start = 0, end = array.size()-1;
        while (start < end) {
            if (array.get(start++) != array.get(end--))
                return false;
        } return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        System.out.println(isSymmetric(root));
    }
}
