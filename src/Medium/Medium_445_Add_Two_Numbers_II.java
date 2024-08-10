// 445. Add Two Numbers II
package Medium;
import java.util.Stack;

public class Medium_445_Add_Two_Numbers_II {
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
        int[] arr = {7,2,4,3};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        int[] arr2 = {5,6,4};
        ListNode node2 = new ListNode(arr2[0]);
        temp = node2;
        for (int i=1; i<arr2.length; i++) {
            temp.next = new ListNode(arr2[i]);
            temp = temp.next;
        }
        printNodes(node);
        printNodes(node2);
        ListNode result = addTwoNumbers02(node, node2);
        printNodes(result);
    }

    // Solution -> 01 By Reversing the Lists
    public static ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        } return prev;
    }
    public static ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode connector = l1, head = l1;
        int carry = 0, sum;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum > 9) {
                l1.val = sum - 10;
                carry = 1;
            } else {
                l1.val = sum;
                carry = 0;
            }
            connector = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            if (sum > 9) {
                l1.val = sum - 10;
                carry = 1;
            } else {
                l1.val = sum;
                carry = 0;
            }
            connector = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            if (sum > 9) {
                l2.val = sum - 10;
                carry = 1;
            } else {
                l2.val = sum;
                carry = 0;
            }
            connector.next = l2;
            connector = connector.next;
            l2 = l2.next;
        }
        if (carry > 0) connector.next = new ListNode(carry);
        return reverseList(head);
    }
    // Solution -> 02 Using Stack
    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        ListNode temp1 = l1, temp2 = l2;
        // Push nodes of l1 into stack1
        while (temp1 != null) {
            stack1.push(temp1);
            temp1 = temp1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        // Push nodes of l2 into stack2
        while (temp2 != null) {
            stack2.push(temp2);
            temp2 = temp2.next;
        }
        ListNode result = null;
        int carry = 0;
        // Traverse both lists from the end
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop().val;
            if (!stack2.isEmpty()) sum += stack2.pop().val;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
            carry = sum / 10;
        } return result;
    }
}
