// 1367. Linked List in Binary Tree
package Medium;

public class Medium_1367_Linked_List_in_Binary_Tree {
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
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (root.val == head.val)
            if (isSamePath(head, root)) return true;

        // Check the left subtree
        if (isSubPath(head, root.left)) return true;
        // Check the right subtree
        if (isSubPath(head, root.right)) return true;
        return false;
    }
    private static boolean isSamePath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val) {
            // Check the next node and left subtree
            if (isSamePath(head.next, root.left)) return true;
            // Check next node and right subtree
            if (isSamePath(head.next, root.right)) return true;
        } return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        System.out.println(isSubPath(head, root));
    }
}
