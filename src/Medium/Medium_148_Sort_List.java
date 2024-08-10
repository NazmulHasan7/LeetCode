// Medium 148. Sort List
package Medium;

public class Medium_148_Sort_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            } currentNode = currentNode.next;
        }
        if (l1 != null) currentNode.next = l1;
        if (l2 != null) currentNode.next = l2;
        return dummyNode.next;
    }
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head; // List is already sorted

        ListNode mid = getMidNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node = new ListNode(5);
        head.next = node;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(0);
        node = node.next;
        ListNode result = sortList(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
