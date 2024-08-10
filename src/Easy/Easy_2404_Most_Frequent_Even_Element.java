// 2404. Most Frequent Even Element
package Easy;
import java.util.HashMap;
import java.util.Map;

public class Easy_2404_Most_Frequent_Even_Element {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        // Get maximum frequency
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                maxCount = Math.max(map.get(num), maxCount);
            }
        }
        // Get minimum number with the maximum frequency
        int minNumber = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount)
                minNumber = Math.min(minNumber, entry.getKey());
        } return minNumber == Integer.MAX_VALUE ? -1 : minNumber;
    }
    public static int mostFrequentEvenFaster(int[] nums) {
        int[] frequency = new int[100001];
        int maxCount = 0, minNumber = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 0) {
                frequency[num]++;
                if (frequency[num] > maxCount) {
                    maxCount = frequency[num];
                    minNumber = num;
                } else if (frequency[num] == maxCount)
                    minNumber = Math.min(minNumber, num);
            }
        } return minNumber == Integer.MAX_VALUE ? -1 : minNumber;
    }
    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[] {0,1,2,2,4,4,1}));
        System.out.println(mostFrequentEven(new int[] {4,4,4,9,2,4}));
        System.out.println(mostFrequentEven(new int[] {29,47,21,41,13,37,25,7}));

        System.out.println(mostFrequentEvenFaster(new int[] {0,1,2,2,4,4,1}));
        System.out.println(mostFrequentEvenFaster(new int[] {4,4,4,9,2,4}));
        System.out.println(mostFrequentEvenFaster(new int[] {29,47,21,41,13,37,25,7}));
    }
}
