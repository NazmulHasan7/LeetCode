// 1721. Swapping Nodes in a Linked List
package Medium;

public class Medium_1721_Swapping_Nodes_in_a_Linked_List {
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
    public static ListNode swapNodes(ListNode head, int k) {
        // Since k <= n (Length of ListNode)
        int index = 0;
        ListNode tempNode, node1, node2;
        tempNode = node1 = node2 = head;
        while (++index < k)
            tempNode = tempNode.next;
        node1 = tempNode;

        // When tempNode reaches the end, node2 reaches n-k index
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            node2 = node2.next;
        }
        int tempValue = node1.val;
        node1.val = node2.val;
        node2.val = tempValue;
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
        ListNode result = swapNodes(node, 2);
        printNodes(result);
    }
}
