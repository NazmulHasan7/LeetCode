// 82. Remove Duplicates from Sorted List II
package Medium;

public class Medium_82_Remove_Duplicates_from_Sorted_List_II {
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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currentNode = head;

        boolean dupFound;
        while (currentNode != null) {
            dupFound = false;
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode = currentNode.next;
                dupFound = true;
            }
            if (dupFound) prevNode.next = currentNode.next;
            else prevNode = currentNode;
            currentNode = currentNode.next;
        } return dummyNode.next;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        ListNode result = deleteDuplicates(node);
        printNodes(result);
    }
}
