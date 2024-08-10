// 532. K-diff Pairs in an Array
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_532_K_diff_Pairs_in_an_Array {
    public static int findPairs(int[] nums, int k) {
        // To store the frequency of numbers
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        int count = 0;
        for (int key : map.keySet()) {
            // Edge case : when k = 0, a number can only pair with itself
            if (k == 0 && map.get(key) > 1)
                count++;
            else if (k > 0 && map.containsKey(key + k))
                count++;
        } return count;
    }
    public int findPairsBetter(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, answer = 0;
        int n = nums.length;

        while(right < n) {
            if(right != left && nums[right]-nums[left] == k ) {
                answer++;
                right++;
                left++;

                while(left<n && nums[left]==nums[left-1])
                    left++;
                while(right<n && nums[right]==nums[right-1])
                    right++;
            } else if(right == left || nums[right]-nums[left]<k) {
                right++;
            } else {
                left++;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3,1,4,1,5},2));
        System.out.println(findPairs(new int[]{1,2,3,4,5},1));
        System.out.println(findPairs(new int[]{1,3,1,5,4},0));
    }
}
