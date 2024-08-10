// 2487. Remove Nodes From Linked List
package Medium;

public class Medium_2487_Remove_Nodes_From_Linked_List {
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
    public static ListNode reverseNodes(ListNode current) {
        ListNode nextNode, prev = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } return prev;
    }
    public static ListNode removeNodes(ListNode head) {
        ListNode prev, current;
        current = head;
        // Reverse the LinkedList
        prev = reverseNodes(current);

        // Now traverse in the reversed order
        int maxvalue = 0;
        current = head = prev;
        while (current != null) {
            if (current.val < maxvalue) {
                prev.next = current.next;
            } else {
                maxvalue = current.val;
                prev = current;
            } current = current.next;
        }
        head = reverseNodes(head);
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,13,3,8};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        ListNode result = removeNodes(node);
        printNodes(result);
    }
}
