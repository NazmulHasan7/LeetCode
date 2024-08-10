// 706. Design HashMap
package Easy;
import java.util.LinkedList;

public class Easy_706_Design_HashMap {
    static class MyHashMap {
        static class Node {
            int key;
            int value;
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private int bucketSize;
        private LinkedList<Node>[] buckets;
        public MyHashMap() {
            bucketSize = 1000;
            buckets = new LinkedList[bucketSize];
            for (int index=0; index<bucketSize; index++)
                buckets[index] = new LinkedList<>();
        }
        public int getBucketIndex(Integer key) {
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % bucketSize;
        }
        public int getDataIndex(int key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            for (int i=0; i<list.size(); i++)
                if (list.get(i).key == key) return i;
            return -1;
        }
        public void put(int key, int value) {
            int bucketIndex = getBucketIndex(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            if (dataIndex == -1)
                buckets[bucketIndex].add(new Node(key, value));
            else buckets[bucketIndex].get(dataIndex).value = value;
        }
        public int get(int key) {
            int bucketIndex = getBucketIndex(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            if (dataIndex == -1) return -1;
            else return buckets[bucketIndex].get(dataIndex).value;
        }
        public void remove(int key) {
            int bucketIndex = getBucketIndex(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            if (dataIndex != -1)
                buckets[bucketIndex].remove(dataIndex);
        }
    }
    static class MyHashMapBetter {
        static class Node{
            int key;
            int val;
            Node next;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        Node[] storage;
        private int hash(int key){
            return key % 10000;
        }
        public MyHashMapBetter() {
            this.storage = new Node[10000];
        }
        private Node find(Node node, int key) {
            Node prev = null;
            Node curr = node;
            while(curr!= null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            } return prev;
        }
        public void put(int key, int value) {
            int hash = hash(key);
            if(storage[hash] == null)
                storage[hash] = new Node(-1, -1);

            Node prev = find(storage[hash], key);
            if(prev.next == null)
                prev.next = new Node(key, value);
            else prev.next.val = value;
        }
        public int get(int key) {
            int hash = hash(key);
            if(storage[hash] == null) return -1;
            Node prev = find(storage[hash], key);
            if(prev.next == null) return -1;
            return prev.next.val;
        }
        public void remove(int key) {
            int hash = hash(key);
            if(storage[hash] == null) return;
            Node prev = find(storage[hash], key);
            if(prev.next == null) return;
            prev.next = prev.next.next;
        }
    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(map);
    }
}
