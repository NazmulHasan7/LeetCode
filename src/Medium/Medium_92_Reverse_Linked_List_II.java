// 92. Reverse Linked List II
package Medium;

public class Medium_92_Reverse_Linked_List_II {
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        int index = 1;
        ListNode node = head;
        ListNode prevNode = dummyNode;
        while (index < left) {
            prevNode = prevNode.next;
            node = node.next;
            index++;
        }
        // Reverse the nodes
        ListNode revHead = node;
        ListNode prev = node;
        ListNode next = null;
        while (index <= right) {
            index++;
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        // reverse head node points to next node after reversal end index
        revHead.next = node;
        // Node before reversal start index points to last reversed node
        prevNode.next = prev;
        return dummyNode.next;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        ListNode result = reverseBetween(node, 2, 4);
        printNodes(result);
    }
}
