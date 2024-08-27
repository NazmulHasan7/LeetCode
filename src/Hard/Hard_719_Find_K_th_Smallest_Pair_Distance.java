// 719. Find K-th Smallest Pair Distance
package Hard;
import java.util.Arrays;

public class Hard_719_Find_K_th_Smallest_Pair_Distance {
    static int n;
    public static int smallestDistancePair(int[] nums, int k) {
        // Binary Search + Sliding Window technique
        Arrays.sort(nums);
        n = nums.length;
        int start = 0; // lowest distance
        int end = nums[n-1] - nums[0]; // highest distance

        int pairCount, answer = 0;
        while (start <= end) {
            // distance
            int mid = start + (end - start) / 2;
            pairCount = getPairCount(nums, mid);
            if (pairCount < k) {
                start = mid + 1; // to get more pairs
            } else {
                answer = mid; // could be the potential answer
                end = mid - 1;
            }
        } return answer;
    }
    private static int getPairCount(int[] nums, int distance) {
        int leftPtr = 0, rightPtr = 1;
        int pairCount = 0;
        while (rightPtr < n) {
            while (nums[rightPtr] - nums[leftPtr] > distance)
                leftPtr++;

            pairCount += (rightPtr - leftPtr);
            rightPtr++;
        } return pairCount;
    }
    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1,3,1}, 1));
        System.out.println(smallestDistancePair(new int[]{1,1,1}, 2));
        System.out.println(smallestDistancePair(new int[]{1,6,1}, 3));
    }
}