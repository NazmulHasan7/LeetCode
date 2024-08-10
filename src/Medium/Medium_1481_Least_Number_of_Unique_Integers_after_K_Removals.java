// 1481. Least Number of Unique Integers after K Removals
package Medium;
import java.util.*;

public class Medium_1481_Least_Number_of_Unique_Integers_after_K_Removals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x,0)+1);

        // Maintain a min heap {value, frequency}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});

        while (k > 0)
            k -= Objects.requireNonNull(minHeap.poll())[1];
        // If k is negative, we have removed part of the last group, so we should add 1 back
        return k < 0 ? minHeap.size() + 1 : minHeap.size();
    }
    public int findLeastNumOfUniqueIntsBetter(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x,0) + 1);

        int[] sortedFreq = new int[map.size()];
        int idx = 0;
        for (int freq : map.values())
            sortedFreq[idx++] = freq;

        Arrays.sort(sortedFreq);

        idx = 0;
        for (int freq : sortedFreq) {
            if (k < freq) break;
            k -= freq;
            idx++;
        }
        return sortedFreq.length - idx;
    }
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5,5,4},1));
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},2));
    }
}
