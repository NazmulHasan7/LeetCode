// 109. Convert Sorted List to Binary Search Tree
package Medium;

public class Medium_109_Convert_Sorted_List_to_Binary_Search_Tree {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
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
    public static ListNode findMid(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        } return slow;
    }
    public static TreeNode convert(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode mid = findMid(start, end);

        TreeNode root = new TreeNode(mid.val);
        root.left = convert(start, mid);
        root.right = convert(mid.next, end);
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = convert(head, null);
        return root;
    }
    public static TreeNode sortedListToBSTBetter(ListNode head) {
        if (head == null) return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head, fast = head, prevMid = null;
        while (fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        prevMid.next = null;
        root.left = sortedListToBSTBetter(head);
        root.right = sortedListToBSTBetter(slow.next);
        return root;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        int[] arr = {-3,0,5,9};
        ListNode temp = head;
        for (int a : arr) {
            temp.next = new ListNode(a);
            temp = temp.next;
        }
        TreeNode root = sortedListToBST(head);
        System.out.println(root.val);
        System.out.println(sortedListToBSTBetter(head).val);
    }
}
