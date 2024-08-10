// 2807. Insert Greatest Common Divisors in Linked List
package Medium;

public class Medium_2807_Insert_Greatest_Common_Divisors_in_Linked_List {
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
    public static int getGCD(int num1, int num2) {
        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        while (num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        } return num1;
    }
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null)
            return head;
        ListNode currentNode = head, next;
        while (currentNode.next != null) {
            next = currentNode.next;
            currentNode.next = new ListNode(getGCD(currentNode.val, currentNode.next.val));
            currentNode.next.next = next;
            currentNode = next;
        } return head;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {18,6,10,3};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ListNode result = insertGreatestCommonDivisors(node);
        printNodes(result);
    }
}
