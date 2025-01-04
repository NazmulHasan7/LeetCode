// 430. Flatten a Multilevel Doubly Linked List
package Medium;

public class Medium_430_Flatten_a_Multilevel_Doubly_Linked_List {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public static Node flatten(Node head) {
        if (head == null) return null;

        Node pointer = head;
        while (pointer != null) {
            // Case 1 -> No child ->
            if (pointer.child == null) {
                pointer = pointer.next;
            } else { // Case 2 -> Has child
                Node childTail = pointer.child;
                // Find the tail of the child
                while (childTail.next != null)
                    childTail = childTail.next;

                // Link child tail with the next node to the pointer
                childTail.next = pointer.next;
                if (pointer.next != null)
                    pointer.next.prev = childTail;

                // Link pointer with the child as the next node
                pointer.next = pointer.child;
                pointer.child.prev = pointer;
                pointer.child = null; // unlink the child
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.prev = head;
        System.out.println(flatten(head).val);
    }
}
