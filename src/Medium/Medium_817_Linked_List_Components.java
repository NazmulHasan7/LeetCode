// 817. Linked List Components
package Medium;
import java.util.HashSet;

public class Medium_817_Linked_List_Components {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        ListNode pointer = head;
        int count = 0;
        boolean check = false;

        while (pointer != null) {
            while (pointer != null && set.contains(pointer.val)) {
                check = true;
                // set.remove(pointer.val);
                pointer = pointer.next;
            }
            if (check) count++;
            check = false;
            if (pointer != null) pointer = pointer.next;
        }
        return count;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        System.out.println(numComponents(node, new int[]{0,1,3}));
    }
}
