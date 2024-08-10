// 237. Delete Node in a Linked List
package Medium;

public class Medium_237_Delete_Node_in_a_Linked_List {
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
    public static void deleteNode(ListNode node) {
        // Since head is not given and node is guaranteed not to be the last node
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        int[] arr = {0,3,1,0,4,5,2,0};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        deleteNode(node.next);
        printNodes(node);
    }
}
