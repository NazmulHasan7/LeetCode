// 19. Remove Nth Node From End of List
package Medium;

public class Medium_19_Remove_Nth_Node_From_End_of_List {
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode tempNode = head;
        while (n-- > 0)
            tempNode = tempNode.next;

        // When n is the LastNode then delete head
        if (tempNode == null)
            return head.next;

        ListNode targetNode = head, prevNode = head;
        while (tempNode != null) {
            tempNode = tempNode.next;
            prevNode = targetNode;
            targetNode = targetNode.next;
        }
        prevNode.next = targetNode.next;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ListNode result = removeNthFromEnd(node, 1);
        printNodes(result);
    }
}
