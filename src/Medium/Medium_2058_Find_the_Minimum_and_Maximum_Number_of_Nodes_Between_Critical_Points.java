// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
package Medium;
import java.util.Arrays;

public class Medium_2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int position = 1; // current node position
        int firstCriticalPoint = 0; // max distance = last - first critical point
        int prevCriticalPoint = 0; // to track the minimum critical point

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstCriticalPoint == 0) {
                    firstCriticalPoint = position;
                } else {
                    maxDistance = position - firstCriticalPoint;
                    minDistance = Math.min(minDistance, position - prevCriticalPoint);
                }
                prevCriticalPoint = position;
            }
            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }

        if (minDistance == Integer.MAX_VALUE || maxDistance == Integer.MIN_VALUE)
            return new int[]{-1, -1};
        return new int[]{minDistance, maxDistance};
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }
}
