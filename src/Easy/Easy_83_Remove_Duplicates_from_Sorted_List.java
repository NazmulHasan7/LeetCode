// 83. Remove Duplicates from Sorted List
package Easy;

public class Easy_83_Remove_Duplicates_from_Sorted_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val)
                current.next = current.next.next;
            else current = current.next;
        } return head.next;
    }
}
