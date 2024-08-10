// 2006. Count Number of Pairs With Absolute Difference K
package Easy;
import java.util.HashMap;

public class Easy_2006_Count_Number_of_Pairs_With_Absolute_Difference_K {
    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (Math.abs(nums[i]-nums[j]) == k)
                    count++;
        return count;
    }
    public static int countKDifferenceMap(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            count += map.getOrDefault(num+k, 0);
            count += map.getOrDefault(num-k, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        } return count;
    }
    public static int countKDifferenceBetter(int[] nums, int k) {
        int[] freq = new int[101];
        for (int num : nums)
            freq[num]++;
        int count = 0;
        for (int i=k; i<freq.length; i++)
            count += freq[i] * freq[i-k];
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        System.out.println(countKDifference(arr, 1));
        System.out.println(countKDifferenceBetter(arr, 1));
    }
}
