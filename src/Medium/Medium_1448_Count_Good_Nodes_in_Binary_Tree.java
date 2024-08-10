// 1448. Count Good Nodes in Binary Tree
package Medium;

public class Medium_1448_Count_Good_Nodes_in_Binary_Tree {
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
    static int answer = 0;
    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return answer;
    }
    private static void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            answer++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(goodNodes(root));
    }
}
