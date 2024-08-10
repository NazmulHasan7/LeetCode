// 707. Design Linked List
package Medium;
import java.util.ArrayList;

public class Medium_707_Design_Linked_List {
    static class Node {
        int value;
        Node next;
        Node() {}
        Node(int value) {this.value = value;}
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    static class MyLinkedList {
        int size;
        Node head;
        public MyLinkedList() {
            size = 0;
            head = null;
        }
        public int get(int index) {
            if (index<0 || index>=size) return -1;
            Node currentNode = head;
            for (int i=0; i<index; i++)
                currentNode = currentNode.next;
            return currentNode.value;
        }
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }
        public void addAtIndex(int index, int val) {
            if (index<0 || index>size) return;
            if (index == 0) {
                Node newNode = new Node(val);
                newNode.next = head;
                head = newNode;
            } else {
                Node currentNode = head;
                for (int i=1; i<index; i++)
                    currentNode = currentNode.next;
                currentNode.next = new Node(val, currentNode.next);
            } size++;
        }
        public void deleteAtIndex(int index) {
            if (index<0 || index>= size) return;
            if (index == 0) {
                head = head.next;
            } else {
                Node node = head;
                for (int i=0; i<index-1; i++)
                    node = node.next;
                node.next = node.next.next;
            } size--;
        }
    }
    static class MyLinkedList2 {
        ArrayList<Integer> list;
        public MyLinkedList2() {
            list = new ArrayList<>();
        }
        public int get(int index) {
            if (index >= list.size()) return -1;
            return list.get(index);
        }
        public void addAtHead(int val) {
            list.add(0, val);
        }
        public void addAtTail(int val) {
            list.add(val);
        }
        public void addAtIndex(int index, int val) {
            if (index > list.size()) return;
            list.add(index, val);
        }
        public void deleteAtIndex(int index) {
            if (index >= list.size()) return;
            list.remove(index);
        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));             // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));             // return 3
    }
}
