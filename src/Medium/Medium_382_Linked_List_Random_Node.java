// 382. Linked List Random Node
package Medium;
import java.util.Random;

public class Medium_382_Linked_List_Random_Node {
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
    static class Solution {
        ListNode head = null;
        public Solution(ListNode head) {
            this.head = head;
        }
        public int getRandom() {
            ListNode node = head;
            int result = -1;
            int index = 0;
            Random random = new Random();
            while (node != null) {
                index++;
                // Generate random index between 0 and index-1
                // total possible outcome is index, but favorable outcome is 1
                if (random.nextInt(index) == index-1)
                    result = node.val;
                node = node.next;
            } return result;
        }
    }
    static class SolutionBetter {
        int len=0;
        ListNode headNode=null;
        Random random = new Random();
        public SolutionBetter(ListNode head) {
            headNode=head;
            ListNode temp=head;
            while(temp!=null){
                len++;
                temp=temp.next;
            }
        }
        public int getRandom() {
            ListNode temp=headNode;
            int rand_index=random.nextInt(len);
            for(int i=0;i<rand_index;i++)
                temp=temp.next;
            return temp.val;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        Solution solution = new Solution(node);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}
