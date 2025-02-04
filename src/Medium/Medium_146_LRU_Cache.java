// 146. LRU Cache
package Medium;
import java.util.HashMap;

public class Medium_146_LRU_Cache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }
    static class LRUCache {
        int capacity;
        HashMap<Integer, Node> cache;
        // Pointers to left (start) and right (end)
        Node leastRecentUsed;
        Node mostRecentUsed;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            leastRecentUsed = new Node(0,0);
            mostRecentUsed = new Node(0,0);
            leastRecentUsed.next = mostRecentUsed;
            mostRecentUsed.prev = leastRecentUsed;
        }

        private void insert(Node node) {
            Node prev = mostRecentUsed.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.mostRecentUsed;
            this.mostRecentUsed.prev = node;
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
                insert(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key))
                remove(cache.get(key));

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);

            if (cache.size() > capacity) {
                cache.remove(leastRecentUsed.next.key);
                remove(leastRecentUsed.next);
            }
        }
    }
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
