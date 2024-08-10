// 108. Convert Sorted Array to Binary Search Tree
package Easy;

public class Easy_108_Convert_Sorted_Array_to_Binary_Search_Tree {
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        return formBST(nums, 0, nums.length-1);
    }
    public static TreeNode formBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = formBST(nums, start, mid-1);
        root.right = formBST(nums, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,5,9};
        System.out.println(sortedArrayToBST(arr).val);
    }
}
