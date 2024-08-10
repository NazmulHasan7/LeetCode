// 24. Swap Nodes in Pairs
package Medium;

public class Medium_24_Swap_Nodes_in_Pairs {
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
    public static ListNode swapPairs(ListNode head) {
        // To point at the head
        ListNode dummyNode = new ListNode(0, head);
        ListNode prevNode = dummyNode;
        ListNode currentNode = head;
        ListNode nextNode, secondNode;

        while (currentNode != null && currentNode.next != null) {
            // currentNode is the firstNode
            secondNode = currentNode.next;
            nextNode = secondNode.next;

            // Swapping the nodes
            secondNode.next = currentNode;
            currentNode.next = nextNode;
            prevNode.next = secondNode;

            // updating the nodes
            prevNode = currentNode;
            currentNode = nextNode;
        } return dummyNode.next;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        ListNode result = swapPairs(node);
        printNodes(result);
    }
}
