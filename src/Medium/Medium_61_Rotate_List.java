// 61. Rotate List
package Medium;

public class Medium_61_Rotate_List {
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
        int[] arr = {1,2,3,4,5};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ListNode result = rotateRight(node, 2);
        printNodes(result);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode currentNode = head;
        int length = 1;
        // Creating a Cyclic LinkedList
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            length++;
        } currentNode.next = head;

        k = k % length;
        int newHeadIndex = length - k;
        ListNode prevNode = head;
        currentNode = head;

        // Traverse to the target node
        while (newHeadIndex-- > 0) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        } prevNode.next = null;
        return currentNode;
    }
}
