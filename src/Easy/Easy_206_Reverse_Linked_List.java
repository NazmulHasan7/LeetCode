// 206. Reverse Linked List
package Easy;

public class Easy_206_Reverse_Linked_List {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode tempNode;
        while (current != null) {
            tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        } return previous;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode result = reverseList(head);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
