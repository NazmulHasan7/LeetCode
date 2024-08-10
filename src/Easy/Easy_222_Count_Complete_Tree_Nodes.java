// 222. Count Complete Tree Nodes
package Easy;

public class Easy_222_Count_Complete_Tree_Nodes {
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
    public static int countNodes(TreeNode root) {
        TreeNode leftNode = root, rightNode = root;
        int leftHeight = 0, rightHeight = 0;

        while (leftNode != null) {
            leftNode = leftNode.left;
            leftHeight++;
        }
        while (rightNode != null) {
            rightNode = rightNode.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight)
            return (int) (Math.pow(2, leftHeight) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(countNodes(root));
    }
}
