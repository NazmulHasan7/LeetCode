// 1171. Remove Zero Sum Consecutive Nodes from Linked List
package Medium;
import java.util.HashMap;

public class Medium_1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeZeroSumSublists(ListNode head) {
        // Map of sum and the node where we get the sum
        HashMap<Long, ListNode> map = new HashMap<>();
        long prefixSum = 0;
        ListNode dummy = new ListNode(0);
        map.put(0L, dummy);
        dummy.next = head;

        while (head != null) {
            prefixSum += head.val;
            // Since we are just adding the numbers
            // We appear to the same sum that we already got before means that
            // We can remove the nodes in between
            if (map.containsKey(prefixSum)) {
                ListNode sumFoundAtPrev = map.get(prefixSum);
                ListNode node = sumFoundAtPrev.next;

                long pSum = prefixSum + node.val;
                while (pSum != prefixSum) {
                    map.remove(pSum);
                    node = node.next;
                    pSum += node.val;
                }
                // node currently points the node for which we got the same sum
                sumFoundAtPrev.next = node.next;
            } else {
                map.put(prefixSum, head);
            }
            head = head.next;
        } return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(removeZeroSumSublists(head));
    }
}
