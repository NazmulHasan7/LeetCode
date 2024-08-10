// 347. Top K Frequent Elements
package Medium;
import java.util.*;

public class Medium_347_Top_K_Frequent_Elements {
    // Note: return the k most frequent elements
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        // Sort the map based on values
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // Return positive -> swap needed : not needed
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] resultArr = new int[k];
        for (int i=0; i<k; i++)
            resultArr[i] = entries.get(i).getKey();
        return resultArr;
    }
    // Time Complexity - O(klogn)
    public static int[] topKFrequentBetter(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        // Bucket Sort approach
        // Create frequency Array where index -> count, value -> map keys
        List<Integer>[] bucket = new List[nums.length+1];
        for (int i=0; i<=nums.length; i++)
            bucket[i] = new ArrayList<>();

        // Store the key values in count index
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            bucket[entry.getValue()].add(entry.getKey());

        // Collect the top k frequent elements
        int[] topK = new int[k];
        int index = 0;
        for (int i=bucket.length-1; i>=0 && index < k; i--) {
            for (int num : bucket[i]) {
                topK[index++] = num;
                if (index == k) break;
            }
        } return topK;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentBetter(new int[] {1,1,1,2,2,3} ,2)));
        System.out.println(Arrays.toString(topKFrequentBetter(new int[] {1} ,1)));
        System.out.println(Arrays.toString(topKFrequentBetter(new int[] {1,2} ,2)));
    }
}
