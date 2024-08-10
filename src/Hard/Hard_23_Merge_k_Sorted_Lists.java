// 23. Merge k Sorted Lists
package Hard;
import java.util.PriorityQueue;

public class Hard_23_Merge_k_Sorted_Lists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.poll(), null);
            head = head.next;
        }
        return newList.next;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        ListNode answer = mergeKLists(new ListNode[] {head1, head2});
        while (answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
    }
}
