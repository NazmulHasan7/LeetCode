// 705. Design HashSet
package Easy;

public class Easy_705_Design_HashSet {
    static class MyHashSet {
        class Node {
            int key;
            Node next;
            public Node (int key) {
                this.key = key;
            }
        }
        private Node[] buckets;
        public MyHashSet() {
            this.buckets = new Node[1000];
        }
        public int hash(int key) {
            return key % 1000;
        }
        public void add(int key) {
            int bucketIndex = hash(key);
            Node node = buckets[bucketIndex];
            if (node == null)
                buckets[bucketIndex] = new Node(key);
            else {
                Node prev = node;
                while (node != null) {
                    // Key already exists
                    if (node.key == key) return;
                    prev = node;
                    node = node.next;
                } prev.next = new Node(key);
            }
        }
        public void remove(int key) {
            int bucketIndex = hash(key);
            Node node = buckets[bucketIndex];
            if (node != null) {
                if (node.key == key) {
                    buckets[bucketIndex] = node.next;
                } else {
                    Node prev = node;
                    while (node != null) {
                        if (node.key == key) {
                            prev.next = node.next;
                            return;
                        } prev = node;
                        node = node.next;
                    }
                }
            }
        }
        public boolean contains(int key) {
            int bucketIndex = hash(key);
            Node node = buckets[bucketIndex];
            while (node != null) {
                if (node.key == key) return true;
                node = node.next;
            } return false;
        }
    }
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        System.out.println(set);
    }
}
