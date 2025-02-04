// 2074. Reverse Nodes in Even Length Groups
package Medium;

public class Medium_2074_Reverse_Nodes_in_Even_Length_Groups {
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

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        int groupNo = 0;
        ListNode current = head;
        ListNode lastGroupLastNode = null;
        ListNode lastEvenGroupNode = null;
        int nodesInLastGroup = 0;

        while (current != null) {
            groupNo++;
            int nodesToAdd = groupNo;
            nodesInLastGroup = 0;

            if ((groupNo & 1) == 1) {
                // Odd length group, no need to reverse
                while (current != null && nodesToAdd > 0) {
                    lastGroupLastNode = current;
                    current = current.next;
                    nodesToAdd--;
                    nodesInLastGroup++;
                }
            } else {
                // Even length group, reverse the nodes
                nodesInLastGroup = reverse(lastGroupLastNode, current, nodesToAdd);
                lastEvenGroupNode = current;
                current = current.next;
            }
        }
        // Handle the last group
        // Odd group but even nodes in the group -> need to reverse
        if ((groupNo & 1) == 1 && (nodesInLastGroup & 1) == 0 && lastEvenGroupNode != null)
            reverse(lastEvenGroupNode, lastEvenGroupNode.next, nodesInLastGroup);
            // Even group but odd nodes int the group -> Already reverse, reverse again to get the original
        else if ((groupNo & 1) == 0 && (nodesInLastGroup & 1) == 1)
            reverse(lastGroupLastNode, lastGroupLastNode.next, nodesInLastGroup);

        return head;
    }

    private static int reverse(ListNode lastGroupLastNode, ListNode groupHead, int nodesToAdd) {
        ListNode current = groupHead;
        ListNode prev = null;
        int nodeCount = 0;

        while (current != null && nodesToAdd > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            nodesToAdd--;
            nodeCount++;
        }
        lastGroupLastNode.next = prev;
        groupHead.next = current;
        return nodeCount;
    }

    // Optimized Code
    public static ListNode reverseEvenLengthGroupsOpt(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        ListNode lastGroupLastNode = null;
        int groupNo = 2;

        while (current != null) {
            ListNode groupHead = current;
            int count = 0;
            while (count < groupNo && current != null) {
                lastGroupLastNode = current;
                current = current.next;
                count++;
            }
            if ((count & 1) == 0) {
                // Reverse the odd length groups
                prev.next = reverse(groupHead, count);
                groupHead.next = current;
                prev = groupHead; // After reverse, start is now the tail
            } else {
                prev = lastGroupLastNode;
            }
            groupNo++;
        }
        return head;
    }

    private static ListNode reverse(ListNode groupHead, int k) {
        ListNode prev = null;
        ListNode curr = groupHead;
        while (k-- > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);
        head = reverseEvenLengthGroups(head);
        System.out.println("Modified List:");
        printList(head);

        System.out.println("\nOriginal List:");
        printList(head);
        head = reverseEvenLengthGroupsOpt(head);
        System.out.println("Modified List:");
        printList(head);
    }
}
