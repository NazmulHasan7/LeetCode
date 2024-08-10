// 142. Linked List Cycle II
package Medium;

public class Medium_142_Linked_List_Cycle_II {
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
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                } return slow;
            }
        } return null;
    }
    public static void main(String[] args) {
        ListNode head  = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next  = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ListNode result = detectCycle(head);
        System.out.println(result.val);
    }
}
