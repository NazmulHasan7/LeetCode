// 725. Split Linked List in Parts
package Medium;

public class Medium_725_Split_Linked_List_in_Parts {
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
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ListNode[] res = splitListToParts(node, 3);
        for (ListNode tempNode : res)
            printNodes(tempNode);
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        ListNode[] result = new ListNode[k];
        int size = length / k;
        int extras = length % k;
        int rIndex = 0;

        ListNode node = head;
        ListNode prev = null;
        while (node != null && rIndex < k) {
            ListNode start = node;
            for (int i=0; i<size; i++) {
                prev = node;
                node = node.next;
            }
            if (extras > 0) {
                prev = node;
                node = node.next;
                extras--;
            }
            prev.next = null;
            result[rIndex++] = start;
        } return result;
    }
}
