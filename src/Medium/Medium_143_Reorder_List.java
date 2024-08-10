// 143. Reorder List
package Medium;

public class Medium_143_Reorder_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        reorderList(node);
        printNodes(node);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } return slow;
    }
    public static ListNode reverseNodes(ListNode head) {
        ListNode node = head;
        ListNode prev = null, next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        } return prev;
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Find the middle of the linked list
        ListNode middleNode = middleNode(head);
        // Find reverse the 2nd half of the linked list
        ListNode endNodes   = reverseNodes(middleNode.next);
        // Part away the lists
        middleNode.next = null;

        ListNode ptr1 = head, ptr2 = endNodes;
        ListNode ptr1next, ptr2next;
        while (ptr1 != null && ptr2 != null) {
            ptr1next = ptr1.next;
            ptr1.next = ptr2;
            ptr2next = ptr2.next;
            ptr2.next = ptr1next;
            ptr1 = ptr1next;
            ptr2 = ptr2next;
        }
    }
}
