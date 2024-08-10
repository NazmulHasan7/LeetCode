// 652. Find Duplicate Subtrees
package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Medium_652_Find_Duplicate_Subtrees {
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
    static List<TreeNode> answer = new ArrayList<>();
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        dfs(root, map);
        return answer;
    }
    private static String dfs(TreeNode root, HashMap<String, Integer> map) {
        if (root == null) return "null";

        // Construct subtree representation string
        StringBuilder sb = new StringBuilder();
        String left = dfs(root.left, map);
        String right = dfs(root.right, map);

        sb.append(root.val).append(",").append(left).append(",").append(right);
        String str = sb.toString();

        // Count occurrences of the subtree string
        int count = map.getOrDefault(str, 0) + 1;
        // Add root to answer if this is the second occurrence of the subtree
        if (count == 2) answer.add(root);
        // Update the map with the count of this subtree string
        map.put(str, count);
        return str;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        List<TreeNode> res = findDuplicateSubtrees(root);
        for (TreeNode node : res)
            System.out.print(node.val + " ");
    }
}
