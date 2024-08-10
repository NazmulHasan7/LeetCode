// 501. Find Mode in Binary Search Tree
package Easy;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Easy_501_Find_Mode_in_Binary_Search_Tree {
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
    public static int[] findMode(TreeNode root) {
        int prev = root.val, count = 0, maxCount = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.val == prev) {
                count++;
            } else {
                if (count == maxCount) {
                    arr.add(prev);
                } else if (count > maxCount) {
                    maxCount = count;
                    arr.clear();
                    arr.add(prev);
                }
                count = 1;
                prev = current.val;
            }
            current = current.right;
        }

        // Handle the last element
        if (count == maxCount) {
            arr.add(prev);
        } else if (count > maxCount) {
            arr.clear();
            arr.add(prev);
        }

        int[] answer = new int[arr.size()];
        int idx = 0;
        for (int a : arr) answer[idx++] = a;
        return answer;
    }

    // Recursive solution
    static int currVal, currCount = 0, maxCount = 0;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        if (root.val == currVal) currCount++;
        else currCount = 1;

        if (currCount == maxCount) {
            arr.add(root.val);
        } else if (currCount > maxCount) {
            maxCount = currCount;
            arr.clear();
            arr.add(root.val);
        }
        currVal = root.val;
        inOrder(root.right);
    }
    public static int[] findModeBetter(TreeNode root) {
        inOrder(root);
        int[] answer = new int[arr.size()];
        for (int i=0; i<answer.length; i++)
            answer[i] = arr.get(i);
        return answer;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 12);
        System.out.println(Arrays.toString(findMode(root)));
        System.out.println(Arrays.toString(findModeBetter(root)));
    }
}
