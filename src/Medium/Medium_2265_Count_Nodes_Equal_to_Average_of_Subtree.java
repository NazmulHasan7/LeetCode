// 2265. Count Nodes Equal to Average of Subtree
package Medium;

public class Medium_2265_Count_Nodes_Equal_to_Average_of_Subtree {
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
    static int averageCount = 0;
    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return averageCount;
    }
    private static int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] {0,0};

        int[] leftPair = dfs(root.left);
        int[] rightPair = dfs(root.right);
        int sum = leftPair[0] + rightPair[0] + root.val;
        int count = leftPair[1] + rightPair[1] + 1;

        if (sum / count == root.val) averageCount++;
        return new int[] {sum, count};
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(averageOfSubtree(root));
    }
}
