// 2130. Maximum Twin Sum of a Linked List
package Medium;

public class Medium_2130_Maximum_Twin_Sum_of_a_Linked_List {
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
        int[] arr = {4,2,2,3};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        System.out.println(pairSum(node));
    }
    public static int pairSum(ListNode head) {
        // Find Middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the 2nd Half of the List
        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Iterate and compare pair sum
        int maxSum = 0;
        while (prev != null) {
            maxSum = Math.max(maxSum, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        } return maxSum;
    }
}
