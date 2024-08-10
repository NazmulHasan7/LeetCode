// 2181. Merge Nodes in Between Zeros
package Medium;

public class Medium_2181_Merge_Nodes_in_Between_Zeros {
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
    public static ListNode mergeNodes(ListNode head) {
        ListNode currentNode = head.next;
        ListNode result;
        result = head;
        int sum;
        while (currentNode != null) {
            sum = 0;
            while (currentNode.val != 0) {
                sum += currentNode.val;
                currentNode = currentNode.next;
            }
            if (sum != 0) {
                result.val = sum;
                result.next = currentNode = currentNode.next;
                result = result.next;
            }
        } return head;
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {0,3,1,0,4,5,2,0};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        ListNode result = mergeNodes(node);
        printNodes(result);
    }
}
