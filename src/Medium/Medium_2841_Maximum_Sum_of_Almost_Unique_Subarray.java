// 2841. Maximum Sum of Almost Unique Sub-array
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_2841_Maximum_Sum_of_Almost_Unique_Subarray {
    public static long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0, windowSum = 0;
        int left = 0, right, n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (right = 0; right < k; right++) {
            int num = nums.get(right);
            map.put(num, map.getOrDefault(num,0)+1);
            windowSum += num;
        }
        if (map.size() >= m) maxSum = windowSum;

        while (right < n) {
            int leftNum = nums.get(left++);
            int rightNum = nums.get(right++);
            windowSum += rightNum - leftNum;

            map.put(rightNum, map.getOrDefault(rightNum,0)+1);
            map.put(leftNum, map.get(leftNum)-1);

            if (map.get(leftNum) == 0) map.remove(leftNum);
            if (map.size() >= m)
                maxSum = Math.max(maxSum, windowSum);
        } return maxSum;
    }
    public long maxSumBetter(List<Integer> nums, int m, int k) {
        long windowSum = 0, maxSum = 0;
        int left = 0, right = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(right < nums.size()) {
            map.put(nums.get(right), map.getOrDefault(nums.get(right),0)+1);
            windowSum += nums.get(right);

            if(right-left+1 == k) {
                if(map.size() >= m)
                    maxSum=Math.max(windowSum,maxSum);

                windowSum = windowSum - nums.get(left);
                if(map.get(nums.get(left)) == 1) {
                    map.remove(nums.get(left));
                } else {
                    map.put(nums.get(left), map.get(nums.get(left))-1);
                } left++;
            } right++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSum(Arrays.asList(2,6,7,3,1,7),3,4));
        System.out.println(maxSum(Arrays.asList(5,9,9,2,4,5,4),1,3));
        System.out.println(maxSum(Arrays.asList(1,2,1,2,1,2,1),3,3));
        System.out.println(maxSum(Arrays.asList(1,1,1,3),2,2));
    }
}
