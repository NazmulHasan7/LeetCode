// 1305. All Elements in Two Binary Search Trees
package Medium;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Medium_1305_All_Elements_in_Two_Binary_Search_Trees {
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
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        inOrder(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        inOrder(root2, l2);

        List<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                arr.add(l1.get(i++));
            } else {
                arr.add(l2.get(j++));
            }
        }
        while (i < l1.size())
            arr.add(l1.get(i++));
        while (j < l2.size())
            arr.add(l2.get(j++));

        return arr;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        int[] arr = new int[]{1,4};
        for (int a : arr)
            insertIntoBST(root1, a);
        TreeNode root2 = new TreeNode(1);
        arr = new int[]{0,3};
        for (int a : arr)
            insertIntoBST(root2, a);
        System.out.println(Arrays.toString(getAllElements(root1, root2).toArray()));
    }
}
