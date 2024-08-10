// 21. Merge Two Sorted Lists
package Easy;

public class Easy_21_Merge_Two_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode currentHead = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentHead.next = list1;
                list1 = list1.next;
            } else {
                currentHead.next = list2;
                list2 = list2.next;
            } currentHead = currentHead.next;
        }
        if (list1 != null)
            currentHead.next = list1;
        else currentHead.next = list2;
        return head.next;
    }
}
