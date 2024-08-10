// 1315. Sum of Nodes with Even-Valued Grandparent
package Medium;

public class Medium_1315_Sum_of_Nodes_with_Even_Valued_Grandparent {
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
    private static int sum = 0;
    public static int sumEvenGrandparent(TreeNode root) {
        getSum(root);
        return sum;
    }
    private static void getSum(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null)
                    sum += root.left.left.val;
                if (root.left.right != null)
                    sum += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null)
                    sum += root.right.left.val;
                if (root.right.right != null)
                    sum += root.right.right.val;
            }
        }
        getSum(root.left);
        getSum(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(sumEvenGrandparent(root));
    }
}
