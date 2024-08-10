// 105. Construct Binary Tree from Preorder and Inorder Traversal
package Medium;
import java.util.HashMap;

public class Medium_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
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
    static HashMap<Integer, Integer> inOrderMap; // [Value, Index]
    static int preIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
            inOrderMap.put(inorder[i], i);

        return buildTree(preorder, 0, inorder.length-1);
    }
    private static TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (start == end) return root;

        int rootIndex = inOrderMap.get(root.val);
        root.left = buildTree(preorder, start, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex + 1, end);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,17}, new int[]{9,3,15,20,7}).val);
        System.out.println(buildTree(new int[]{-1}, new int[]{-1}).val);
    }
}
