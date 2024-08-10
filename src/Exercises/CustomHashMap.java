package Exercises;
import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap {
    static class MyHashmap <Key, Value> {
        // Linked List Node
        private class Node {
            Key key;
            Value value;
            public Node (Key key, Value value) {
                this.key = key;
                this.value = value;
            }
        }
        private int nodeSize;
        private int bucketSize;
        // K --> Threshold (Maximum size of each bucket)
        private final double K = 2;
        // Array of LinkedList --> buckets
        private LinkedList<Node>[] buckets;
        @SuppressWarnings("unchecked")
        public MyHashmap() {
            this.bucketSize = 5;
            this.buckets = new LinkedList[this.bucketSize];
            // Creating LinkedList in each bucket
            for (int index=0; index<bucketSize; index++)
                buckets[index] = new LinkedList<>();
        }
        public int myHashFunction(Key key) {
            int bucketIndex = key.hashCode();
            // hashCode() can return positive or negative
            // We want the hashcode to be within 0 to bucketSize - 1
            return Math.abs(bucketIndex) % bucketSize;
        }
        public int getDataIndex(Key key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            for (int index=0; index<list.size(); index++)
                if (list.get(index).key == key)
                    return index;
            return -1;
        }
        public void rehash() {
            // Store old buckets
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[bucketSize * 2];
            // Store old bucket nodes into the map
            for (LinkedList<Node> oldBucket : oldBuckets)
                for (Node node : oldBucket)
                    put(node.key, node.value);
        }
        public void put(Key key, Value value) {
            // Get bucket index from hash function
            int bucketIndex = myHashFunction(key);
            int dataIndex   = getDataIndex(key, bucketIndex);

            if (dataIndex == -1) {
                // Key doesn't exist, add new one
                Node node = new Node(key, value);
                buckets[bucketIndex].add(node);
                nodeSize++;
                // Check if rehashing is required
                if ((nodeSize/(double)bucketSize) > K)
                    rehash(); // Rehashing is required
            } else {
                // Update the node value
                buckets[bucketIndex].get(dataIndex).value = value;
            }
        }
        public Value get(Key key) {
            int bucketIndex = myHashFunction(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            if (dataIndex == -1) return null;
            else return buckets[bucketIndex].get(dataIndex).value;
        }
        public boolean containsKey(Key key) {
            int bucketIndex = myHashFunction(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            return dataIndex != -1;
        }
        public void remove(Key key) {
            int bucketIndex = myHashFunction(key);
            int dataIndex = getDataIndex(key, bucketIndex);
            if (dataIndex != -1) {
                buckets[bucketIndex].remove(dataIndex);
                nodeSize--;
            }
        }
        public ArrayList<Key> keySet() {
            ArrayList<Key> keys = new ArrayList<>();
            for (LinkedList<Node> bucket : buckets)
                for (Node node : bucket)
                    keys.add(node.key);
            return keys;
        }
        public int size() {
            return nodeSize;
        }
        public boolean isEmpty() {
            return nodeSize == 0;
        }
        @Override
        public String toString() {
            String output = "";
            for (LinkedList<Node> bucket : buckets)
                for (Node node : bucket)
                    output += "{"+node.key+ "=" +node.value+"}\n";
            return output;
        }
    }
    public static void main(String[] args) {
        MyHashmap<String, String> map = new MyHashmap<>();
        map.put("GP", "017");
        map.put("BL", "019");
        map.put("RB", "018");
        map.put("AR", "016");
        map.put("TK", "015");
        System.out.println(map);

        if (!map.containsKey("CT"))
            System.out.println("Key doesn't exist");
        else System.out.println("Exists");

        map.remove("AR");
        System.out.println(map);
        System.out.println("Size : " + map.size());
    }
}
