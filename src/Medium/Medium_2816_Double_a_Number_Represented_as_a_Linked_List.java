// 2816. Double a Number Represented as a Linked List
package Medium;

public class Medium_2816_Double_a_Number_Represented_as_a_Linked_List {
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
        int[] arr = {9,9,9};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        ListNode result = doubleItBetter(node);
        printNodes(result);
    }
    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null, next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        } return prev;
    }
    public static ListNode doubleIt(ListNode head) {
        ListNode revHead = reverse(head);
        ListNode node = revHead;
        int carry = 0, value;
        ListNode result = null;
        while (node != null) {
            value = 2 * node.val + carry;
            if (value > 9) {
                node.val = value % 10;
                carry = value / 10;
            } else {
                node.val = value;
                carry = 0;
            }
            result = node;
            node = node.next;
        } if (carry > 0) result.next = new ListNode(carry);
        return reverse(revHead);
    }
    public static ListNode doubleItBetter(ListNode head) {
        if (head != null && head.val > 4)
            head = new ListNode(0, head);
        ListNode node = head;
        while (node != null) {
            node.val = 2 * node.val;
            if (node.next != null && node.next.val > 4) node.val++;
            node.val = node.val % 10;
            node = node.next;
        } return head;
    }
}
