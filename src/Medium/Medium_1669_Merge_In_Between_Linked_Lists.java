// 1669. Merge In Between Linked Lists
package Medium;

public class Medium_1669_Merge_In_Between_Linked_Lists {
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
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tempPointer = list1;
        int index = 0;
        while (index++ < a-1)
            tempPointer = tempPointer.next;
        ListNode pointer1 = tempPointer;

        while (index++ <= b)
            tempPointer = tempPointer.next;
        ListNode pointer2 = tempPointer.next;

        pointer1.next = tempPointer = list2;
        while (tempPointer.next != null)
            tempPointer = tempPointer.next;

        tempPointer.next = pointer2;
        return list1;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6};
        ListNode node1 = new ListNode(arr1[0]);
        ListNode temp = node1;
        for (int i=1; i<arr1.length; i++) {
            temp.next = new ListNode(arr1[i]);
            temp = temp.next;
        }
        int[] arr2 = {1000000,1000001,1000002,1000003,1000004};
        ListNode node2 = new ListNode(arr2[0]);
        temp = node2;
        for (int i=1; i<arr2.length; i++) {
            temp.next = new ListNode(arr2[i]);
            temp = temp.next;
        }
        ListNode result = mergeInBetween(node1, 2, 5, node2);
        printNodes(result);
    }
}
