// 641. Design Circular Deque
package Medium;
import java.util.ArrayList;

public class Medium_641_Design_Circular_Deque {
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
    static class MyCircularDeque {
        int count = 0, size;
        ListNode front = null;
        ListNode tail = null;
        public MyCircularDeque(int k) {
            this.size = k;
        }
        public boolean insertFront(int value) {
            if (count == size) return false;
            ListNode newNode = new ListNode(value);
            if (front == null) {
                front = newNode;
                front.next = null;
                if (tail == null) tail = front;
            } else {
                newNode.next = front;
                front = newNode;
            } count++; return true;
        }
        public boolean insertLast(int value) {
            if (count == size) return false;
            ListNode newNode = new ListNode(value);
            if (front == null) {
                front = newNode;
                front.next = null;
                if (tail == null) tail = front;
            } else {
                tail.next = newNode;
                tail = tail.next;
                tail.next = null;
            } count++; return true;
        }
        public boolean deleteFront() {
            if (count == 0) return false;
            if (front.next == null)
                front = tail = null;
            else front = front.next;
            count--;
            return true;
        }
        public boolean deleteLast() {
            if (count == 0) return false;
            if (front.next == null) {
                front = tail = null;
            } else {
                ListNode tempNode = front;
                while (tempNode.next.next != null)
                    tempNode = tempNode.next;
                tail = tempNode;
                tempNode.next = null;
            }
            count--;
            return true;
        }
        public int getFront() {
            if (count == 0) return -1;
            return front.val;
        }
        public int getRear() {
            if (count == 0) return -1;
            return tail.val;
        }
        public boolean isEmpty() {
            return count == 0;
        }
        public boolean isFull() {
            return count == size;
        }
    }
    static class MyCircularQueue2 {
        ArrayList<Integer> queue;
        int size;
        public MyCircularQueue2(int k) {
            queue = new ArrayList<>();
            size = k;
        }
        public boolean insertFront(int value) {
            if(queue.size() < size){
                queue.add(0,value);
                return true;
            } return false;
        }
        public boolean insertLast(int value) {
            if(queue.size() < size){
                queue.add(value);
                return true;
            } return false;
        }
        public boolean deleteFront() {
            if(!queue.isEmpty()){
                queue.remove(0);
                return true;
            } return false;
        }
        public boolean deleteLast() {
            if(!queue.isEmpty()){
                queue.remove(queue.size()-1);
                return true;
            } return false;
        }
        public int getFront() {
            if(!queue.isEmpty()){
                return queue.get(0);
            } return -1;
        }
        public int getRear() {
            if(!queue.isEmpty()){
                return queue.get(queue.size()-1);
            } return -1;
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
        public boolean isFull() {
            return queue.size() == size;
        }
    }
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        myCircularDeque.getRear();
        myCircularDeque.isFull();
        myCircularDeque.deleteLast();
        myCircularDeque.insertFront(4);
        myCircularDeque.getFront();
    }
}
