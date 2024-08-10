// 1019. Next Greater Node In Linked List
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Medium_1019_Next_Greater_Node_In_Linked_List {
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
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        while (head != null) {
            arrList.add(head.val);
            head = head.next;
            size++;
        }
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int index=0; index<size; index++) {
            while (!stack.isEmpty() && arrList.get(stack.peek()) < arrList.get(index))
                result[stack.pop()] = arrList.get(index);
            // Store the indexes which have smaller values
            stack.push(index);
        } return result;
    }
    public static int[] nextLargerNodesBetter(ListNode head) {
        ListNode node = head;
        int size = 0;
        int stackPtr = -1;
        int[] arrList = new int[10001];

        while (node != null) {
            arrList[size] = node.val;
            node = node.next;
            size++;
        }
        int[] stack = new int[10001];
        int[] result = new int[size];
        for (int index=0; index<size; index++) {
            while (stackPtr >= 0 && arrList[stack[stackPtr]] < arrList[index]) {
                result[stack[stackPtr]] = arrList[index];
                stackPtr--;
            } stackPtr++;
            stack[stackPtr] = index;
        } return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,5,1,9,2,5,1}; // [7,9,9,9,0,5,0,0]
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        System.out.println(Arrays.toString(nextLargerNodes(node)));
    }
}
