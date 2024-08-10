// 1670. Design Front Middle Back Queue
package Medium;

public class Medium_1670_Design_Front_Middle_Back_Queue {
    static class ListNode {
        int val;
        ListNode prev, next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    static class FrontMiddleBackQueue {
        ListNode head, tail, middle;
        int size;
        public FrontMiddleBackQueue() {
            head = tail = middle = null;
            size = 0;
        }
        public void pushFront(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = tail = middle = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } // Since inserting in the front
            if (size % 2 == 1) middle = middle.prev;
            size++;
        }
        public void pushMiddle(int val) {
            ListNode newNode = new ListNode(val);
            if (middle == null) {
                head = tail = middle = newNode;
            } else {
                if (size % 2 == 0) {
                    // Add the middle node after the existing middle node
                    newNode.next = middle.next;
                    if (newNode.next != null) middle.next.prev = newNode;
                    middle.next = newNode;
                    newNode.prev = middle;
                } else {
                    // Push before the existing middle node
                    if (middle.prev != null) middle.prev.next = newNode;
                    newNode.prev = middle.prev;
                    middle.prev = newNode;
                    newNode.next = middle;
                }
                middle = newNode;
                // If middle node becomes the first node
                if (middle.prev == null) head = middle;
            } size++;
        }
        public void pushBack(int val) {
            ListNode newNode = new ListNode(val);
            if (tail == null) {
                head = tail = middle = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } // Since inserting at the end
            if (size > 0 && size % 2 == 0) middle = middle.next;
            size++;
        }
        public int popFront() {
            if (head == null) return -1;
            int result = head.val;
            head = head.next;
            if (head == null) tail = middle = null;
            else head.prev = null;

            if (size > 0 && size % 2 == 0 && middle != null) middle = middle.next;
            size--;
            return result;
        }
        public int popMiddle() {
            if (middle == null) return -1;
            int result = middle.val;
            if (middle.next != null) middle.next.prev = middle.prev;
            if (middle.prev != null) middle.prev.next = middle.next;

            if (size % 2 == 0) middle = middle.next;
            else middle = middle.prev;
            if (middle == null) head = tail = null;
            if (size == 2) head = middle;

            size--;
            return result;
        }
        public int popBack() {
            if (tail == null) return -1;
            int result = tail.val;
            tail = tail.prev;
            if (tail == null) head = middle = null;
            else tail.next = null;

            if (size % 2 == 1 && middle != null) middle = middle.prev;
            size--;
            return result;
        }
    }
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        printNodes(q.head);
        q.popFront();     // return 1 -> [4, 3, 2]
        q.popMiddle();    // return 3 -> [4, 2]
        q.popMiddle();    // return 4 -> [2]
        q.popBack();      // return 2 -> []
        q.popFront();     // return -1 -> [] (The queue is empty)
    }
}
