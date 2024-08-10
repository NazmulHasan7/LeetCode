// 2. Add Two Numbers
package Medium;

public class Medium_2_Add_Two_Numbers {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode head = l1;
        // To concatenate both the lists
        ListNode connector = l1;

        // Keep adding two numbers while reaching the end of any List
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum > 9) {
                carry = 1;
                l1.val = sum % 10;
            } else {
                l1.val = sum;
                carry = 0;
            }
            connector = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        // If more nodes to be added from list1
        while (l1 != null) {
            sum = l1.val + carry;
            if (sum > 9) {
                carry = 1;
                l1.val = sum % 10;
            } else {
                l1.val = sum;
                carry = 0;
            }
            connector = l1;
            l1 = l1.next;
        }
        // If more nodes to be added from list2
        while (l2 != null) {
            sum = l2.val + carry;
            if (sum > 9) {
                carry = 1;
                l2.val = sum % 10;
            } else {
                l2.val = sum;
                carry = 0;
            }
            connector.next = l2;
            connector = connector.next;
            l2 = l2.next;
        }
        // If carry exists
        if (carry > 0)
            connector.next = new ListNode(carry);
        return head;
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
        int[] arr2 = {9,9,9,9};
        ListNode node2 = new ListNode(arr2[0]);
        temp = node2;
        for (int i=1; i<arr2.length; i++) {
            temp.next = new ListNode(arr2[i]);
            temp = temp.next;
        }
        printNodes(node);
        printNodes(node2);
        ListNode result = addTwoNumbers(node, node2);
        printNodes(result);
    }
}
