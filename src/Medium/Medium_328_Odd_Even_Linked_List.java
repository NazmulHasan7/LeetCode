// 328. Odd Even Linked List
package Medium;

public class Medium_328_Odd_Even_Linked_List {
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
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddNodes = head;
        ListNode evenNodes = head.next;
        ListNode evenHead = evenNodes;
        ListNode currentNode = head.next.next;

        boolean oddIndex = true;
        while (currentNode != null) {
            if (oddIndex) {
                oddNodes.next = currentNode;
                oddNodes = currentNode;
            } else {
                evenNodes.next = currentNode;
                evenNodes = currentNode;
            }
            currentNode = currentNode.next;
            oddIndex = !oddIndex;
        }
        oddNodes.next = evenHead;
        evenNodes.next = null;
        return head;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
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
        ListNode result = oddEvenList(node);
        printNodes(result);
    }
}
