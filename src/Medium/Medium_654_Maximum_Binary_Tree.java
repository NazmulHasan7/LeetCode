// 654. Maximum Binary Tree
package Medium;

public class Medium_654_Maximum_Binary_Tree {
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
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return formTree(nums, 0, nums.length-1);
    }
    private static TreeNode formTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int max = -1, maxIdx = -1;
        for (int i=start; i<=end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }
        TreeNode newRoot = new TreeNode(max);
        newRoot.left = formTree(arr, start, maxIdx-1);
        newRoot.right = formTree(arr, maxIdx+1, end);
        return newRoot;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);

        System.out.println(constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}).val);
    }
}
