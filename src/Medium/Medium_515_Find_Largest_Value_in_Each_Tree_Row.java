// 515. Find Largest Value in Each Tree Row
package Medium;
import java.util.List;
import java.util.ArrayList;

public class Medium_515_Find_Largest_Value_in_Each_Tree_Row {
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
    static List<Integer> array = new ArrayList<>();
    public static List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return array;
    }
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (array.size() == level)
            array.add(Integer.MIN_VALUE);

        if (root.val > array.get(level))
            array.set(level, root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(largestValues(root));
    }
}
