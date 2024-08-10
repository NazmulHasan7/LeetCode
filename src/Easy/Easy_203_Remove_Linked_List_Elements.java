// 203. Remove Linked List Elements
package Easy;

public class Easy_203_Remove_Linked_List_Elements {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)
            head = head.next;

        ListNode currentNode = head;
        while(currentNode != null && currentNode.next != null) {
            if (currentNode.next.val == val)
                currentNode.next = currentNode.next.next;
            else currentNode = currentNode.next;
        } return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
        head = removeElements(head, 6);
        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}
