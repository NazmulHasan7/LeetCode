// 257. Binary Tree Paths
package Easy;
import java.util.List;
import java.util.ArrayList;

public class Easy_257_Binary_Tree_Paths {
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
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        String currentPath = Integer.toString(root.val);

        if (root.left == null && root.right == null)
            answer.add(currentPath);

        if (root.left != null) dfs(root.left, currentPath, answer);
        if (root.right != null) dfs(root.right, currentPath, answer);
        return answer;
    }
    private static void dfs(TreeNode root, String currentPath, List<String> answer) {
        currentPath += "->" + root.val;
        if (root.left == null && root.right == null) {
            answer.add(currentPath);
            return;
        }
        if (root.left != null) dfs(root.left, currentPath, answer);
        if (root.right != null) dfs(root.right, currentPath, answer);
    }
    public List<String> binaryTreePathsBetter(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(),ans);
        return ans;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            ans.add(sb.append(root.val).toString());
            return;
        }
        int length = sb.length();
        dfs (root.left, sb.append(root.val).append("->"),ans);
        sb.setLength(length);
        dfs (root.right, sb.append(root.val).append("->"),ans);
        sb.setLength(length);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(binaryTreePaths(root));
    }
}
