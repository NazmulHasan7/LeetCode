// 160. Intersection of Two Linked Lists
package Easy;

public class Easy_160_Intersection_of_Two_Linked_Lists {
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
    public static ListNode getStartingNode(ListNode head, int pos) {
        while (pos-- > 0 && head != null)
            head = head.next;
        return head;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case
        if (headA == null || headB == null) return null;

        // Finding length of both Linked List
        int length1 = 0;
        ListNode currNode = headA;
        while (currNode != null) {
            currNode = currNode.next;
            length1++;
        }
        int length2 = 0;
        currNode = headB;
        while (currNode != null) {
            currNode = currNode.next;
            length2++;
        }
        // Setting up the starting node
        if (length1 > length2) headA = getStartingNode(headA, length1-length2);
        else headB = getStartingNode(headB, length2-length1);

        // Compare the both nodes for intersection
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        } return null;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr1 = {4,1,8,4,5};
        ListNode nodeA = new ListNode(arr1[0]);
        ListNode temp = nodeA;
        for (int i=1; i<arr1.length; i++) {
            temp.next = new ListNode(arr1[i]);
            temp = temp.next;
        }
        int[] arr2 = {5,6,1,8,4,5};
        ListNode nodeB = new ListNode(arr2[0]);
        temp = nodeB;
        for (int i=1; i<arr2.length; i++) {
            temp.next = new ListNode(arr2[i]);
            temp = temp.next;
        }
        printNodes(nodeA);
        printNodes(nodeB);
        ListNode result = getIntersectionNode(nodeA, nodeB);
        System.out.println(result.val);
    }
}
