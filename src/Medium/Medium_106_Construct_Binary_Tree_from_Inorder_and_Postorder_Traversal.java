// 106. Construct Binary Tree from Inorder and Postorder Traversal
package Medium;
import java.util.HashMap;

public class Medium_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
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
    static int postIndex = 0;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        postIndex = postorder.length-1; // for postorder root is at the end

        for (int i=0; i<inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        return buildTree(postorder, 0, inorder.length-1);
    }
    private static TreeNode buildTree(int[] postorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        if (start == end) return root;

        int rootIndex = inOrderMap.get(root.val);
        root.right = buildTree(postorder, rootIndex + 1, end);
        root.left = buildTree(postorder, start, rootIndex - 1);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}).val);
        System.out.println(buildTree(new int[]{-1}, new int[]{-1}).val);
    }
}
