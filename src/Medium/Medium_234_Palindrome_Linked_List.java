// 234. Palindrome Linked List
package Medium;

public class Medium_234_Palindrome_Linked_List {
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
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // Find the middle of the LinkedList
        ListNode slow = head, midNode = slow;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            midNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the 2nd Half of the LinkedList
        ListNode prevNode = null;
        ListNode currentNode = midNode.next;
        ListNode next = null;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = next;
        }
        // Compare the values
        while (prevNode != null) {
            if (head.val != prevNode.val)
                return false;
            head = head.next;
            prevNode = prevNode.next;
        } return true;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        printNodes(node);
        System.out.println(isPalindrome(node));
    }
}
