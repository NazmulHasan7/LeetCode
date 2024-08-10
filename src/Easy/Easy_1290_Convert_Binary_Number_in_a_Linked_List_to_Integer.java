// 1290. Convert Binary Number in a Linked List to Integer
package Easy;

public class Easy_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {
    static class ListNode {
        int value;
        ListNode next;
        ListNode() {}
        public ListNode(int value) {
            this.value = value;
        }
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
    public static int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.value;
            head = head.next;
        } return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode head = new ListNode(arr[0]);
        ListNode tempHead = head;
        for (int i=1; i<arr.length; i++) {
            tempHead.next = new ListNode(arr[i]);
            tempHead = tempHead.next;
        }
        System.out.println(getDecimalValue(head));
    }
}
