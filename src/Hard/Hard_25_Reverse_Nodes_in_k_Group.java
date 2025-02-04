// 25. Reverse Nodes in k-Group
package Hard;

public class Hard_25_Reverse_Nodes_in_k_Group {
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
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prevGroupTail = dummyNode;
        ListNode current = head;
        int count = 0;

        while (current != null) {
            count++;
            ListNode nextNode = current.next;
            if (count == k) {
                ListNode groupStart = prevGroupTail.next; // start node (e.g. dummy.next (head) == start)
                prevGroupTail.next = reverse(groupStart, k); // dummy -> 2
                groupStart.next = nextNode; // After reversal start is the tail node pointing to the next group head
                prevGroupTail = groupStart;
                count = 0; // Reset count after processing one group
            }
            current = nextNode;
        }
        return dummyNode.next;
    }
    private static ListNode reverse(ListNode groupHead, int k) {
        ListNode current = groupHead;
        ListNode prev = null;
        ListNode next;

        while (current != null && k > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        return prev;
    }
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);
        head = reverseKGroup(head, 2);
        System.out.println("Modified List:");
        printList(head);
    }
}
