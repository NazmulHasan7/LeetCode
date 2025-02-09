// 2349. Design a Number Container System
package Medium;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Medium_2349_Design_a_Number_Container_System {
    static class NumberContainers {
        HashMap<Integer, Integer> indexNumberMap;
        // TreeSet is used to maintain an ordered set and avoid duplicates
        HashMap<Integer, TreeSet<Integer>> numberIndices;

        public NumberContainers() {
            numberIndices = new HashMap<>();
            indexNumberMap = new HashMap<>();
        }
        public void change(int index, int number) { // -> O(log N)
            int currNumber = indexNumberMap.getOrDefault(index, Integer.MIN_VALUE);
            if (currNumber != number) {
                System.out.println(number);
                // Remove the index from current number
                if (currNumber != Integer.MIN_VALUE && numberIndices.containsKey(currNumber)) {
                    TreeSet<Integer> indices = numberIndices.get(currNumber);
                    indices.remove(index); // O(log(n))
                    if (indices.isEmpty()) numberIndices.remove(currNumber);
                }
            }
            // Replace the new number to the index
            indexNumberMap.put(index, number);
            numberIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }
        public int find(int number) { // O(1)
            if (!numberIndices.containsKey(number))
                return -1;
            return numberIndices.get(number).first();
        }

        /* Map<Integer, Integer> data;
        Map<Integer, PriorityQueue<Integer>> indices;

        public NumberContainers() {
            data = new HashMap<>();
            indices = new HashMap<>();
        }

        public void change(int index, int number) {
            data.put(index, number);
            indices.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> pq = indices.getOrDefault(number, new PriorityQueue<>());

            while (!pq.isEmpty()) {
                int index = pq.peek();
                if (data.get(index) == number)
                    return index;
                else
                    pq.poll(); // those indices are occupied by other numbers
            }
            return -1;
        } */
    }
    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10));
        nc.change(1, 10);
        nc.change(1, 10);
        System.out.println(nc.find(10));
        nc.change(1, 20);
        System.out.println(nc.find(10));
    }
}
