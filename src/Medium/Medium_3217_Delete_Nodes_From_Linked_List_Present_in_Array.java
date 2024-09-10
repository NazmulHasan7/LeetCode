// 3217. Delete Nodes From Linked List Present in Array
package Medium;
import java.util.HashSet;

public class Medium_3217_Delete_Nodes_From_Linked_List_Present_in_Array {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        System.out.println(set);

        ListNode tempHead = new ListNode(-1, head);
        ListNode temp = tempHead;
        while (temp.next != null) {
            if (set.contains(temp.next.val))
                temp.next = temp.next.next;
            else temp = temp.next;
        }
        return tempHead.next;
    }
}
