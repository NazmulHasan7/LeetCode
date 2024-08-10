// 147. Insertion Sort List
package Medium;

public class Medium_147_Insertion_Sort_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(-1, head);
        ListNode prevNode = head;
        ListNode currNode = head.next;

        while (currNode != null) {
            if (currNode.val >= prevNode.val) {
                prevNode = currNode;
                currNode = currNode.next;
                continue;
            }
            // prevNode => currentNode
            // In case current node < head
            ListNode tempNode = dummyNode;
            // Start searching for insertion index from the beginning
            while (currNode.val > tempNode.next.val)
                tempNode = tempNode.next;

            // Found the insertion point
            // prevNode => currentNode
            // -1 -> 0 -> 2 -> 5 -> 1 -> 8 p => 5->1, c => 1->8, t => 0->2
            prevNode.next = currNode.next; // p => 5->8
            currNode.next = tempNode.next; // c => 1->2
            tempNode.next = currNode;      // t => 0->1
            currNode = prevNode.next;      // c => 8->none
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node = new ListNode(5);
        head.next = node;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(0);
        node = node.next;
        ListNode result = insertionSortList(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
