// 2583. Kth Largest Sum in a Binary Tree
package Medium;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Medium_2583_Kth_Largest_Sum_in_a_Binary_Tree {
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Long> arrList = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            arrList.add(sum);
        }

        if(k > arrList.size()) return -1;
        Collections.sort(arrList);
        return arrList.get(arrList.size() - k);
    }
    static List<Long> arr = new ArrayList<>();
    public static long kthLargestLevelSumDFS(TreeNode root, int k) {
        dfs(root, 0);
        if (arr.size() < k) return -1;
        Collections.sort(arr);
        return arr.get(arr.size() - k);
    }
    private static void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (arr.size() == level) arr.add(0L);

        long sum = arr.get(level) + root.val;
        arr.set(level, sum);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(kthLargestLevelSumDFS(root, 2));
    }
}
