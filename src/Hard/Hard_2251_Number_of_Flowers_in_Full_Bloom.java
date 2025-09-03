// 2251. Number of Flowers in Full Bloom
package Hard;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Hard_2251_Number_of_Flowers_in_Full_Bloom {
    // Solved using line sweep algorithm
    // Need to solve using Sorting & binary search
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1]+1;
            line.put(start, line.getOrDefault(start,0)+1);
            line.put(end, line.getOrDefault(end,0)-1);
        }

        // Map for the count of bloomed flowers
        TreeMap<Integer, Integer> bloomed = new TreeMap<>();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
            count += entry.getValue();
            bloomed.put(entry.getKey(), count);
        }

        int n = people.length;
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            int arrivalTime = people[i];
            Integer prevKey = bloomed.floorKey(arrivalTime);
            if (prevKey == null)
                answer[i] = 0; // people at i came before even a flower is bloomed
            else answer[i] = bloomed.floorEntry(arrivalTime).getValue();
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11})));
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2})));
    }
}
