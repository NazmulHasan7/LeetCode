// 622. Design Circular Queue
package Medium;

public class Medium_622_Design_Circular_Queue {
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
    static class MyCircularQueue {
        int size, count;
        ListNode head, tail;
        public MyCircularQueue(int k) {
            size = k;
            count = 0;
        }
        public boolean enQueue(int value) {
            if (count == size) return false;
            ListNode newNode = new ListNode(value);
            if (head == null || count == 0) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            } tail.next = head;
            count++;
            return true;
        }
        public boolean deQueue() {
            if (head == null || count == 0) return false;
            head = head.next;
            tail.next = head;
            count--;
            return true;
        }
        public int Front() {
            if (count != 0 && head != null)
                return head.val;
            return -1;
        }
        public int Rear() {
            if (count != 0 && tail != null)
                return tail.val;
            return -1;
        }
        public boolean isEmpty() {
            return count == 0;
        }
        public boolean isFull() {
            return size == count;
        }
    }
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());          // return 3
        System.out.println(myCircularQueue.isFull());        // return True
        System.out.println(myCircularQueue.deQueue());       // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());          // return 4
    }
}
