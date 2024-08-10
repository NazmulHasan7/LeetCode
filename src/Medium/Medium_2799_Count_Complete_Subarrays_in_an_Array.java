// 2799. Count Complete Sub-arrays in an Array
package Medium;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_2799_Count_Complete_Subarrays_in_an_Array {
    public static int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int totalDistinct = set.size();

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while (map.size() == totalDistinct) {
                answer += nums.length - right;
                map.put(nums[left], map.get(nums[left])-1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            } right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println(countCompleteSubarrays(new int[]{5,5,5,5}));
    }
}
