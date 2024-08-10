// 138. Copy List with Random Pointer
package Medium;
import java.util.HashMap;

public class Medium_138_Copy_List_with_Random_Pointer {
    static class Node {
        int val;
        Node next;
        Node random;
        Node() {}
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void printNodes(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        } System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {0,3,1,0,4,5,2,0};
        Node node = new Node(arr[0]);
        Node temp = node;
        for (int i=1; i<arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        // Store the nodes in map with corresponding new node
        // Just creating new nodes without any connection
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        // Now connect the nodes
        current = head;
        Node newNode;
        while (current != null) {
            newNode = map.get(current);
            // Since -> Deep Copy
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
            current = current.next;
        } // Return the new LinkedList head
        return map.get(head);
    }
}
